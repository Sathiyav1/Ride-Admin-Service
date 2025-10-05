
#!/usr/bin/env sh
# Lightweight Maven launcher: if system mvn is available, use it; otherwise
# download an Apache Maven binary into .mvn/wrapper/apache-maven-<ver> and run it.

set -e

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
WRAPPER_DIR="$PROJECT_DIR/.mvn/wrapper"
MAVEN_VERSION="3.9.6"
MAVEN_DIR="$WRAPPER_DIR/apache-maven-$MAVEN_VERSION"
MAVEN_BIN="$MAVEN_DIR/bin/mvn"

if command -v mvn >/dev/null 2>&1; then
  exec mvn "$@"
fi

mkdir -p "$WRAPPER_DIR"

if [ ! -x "$MAVEN_BIN" ]; then
  echo "Maven not found: downloading Apache Maven $MAVEN_VERSION..."

  DIST_URL="https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz"
  TMPARCHIVE="$WRAPPER_DIR/apache-maven-$MAVEN_VERSION-bin.tar.gz"

  if command -v curl >/dev/null 2>&1; then
    curl -fL "$DIST_URL" -o "$TMPARCHIVE"
  elif command -v wget >/dev/null 2>&1; then
    wget -q -O "$TMPARCHIVE" "$DIST_URL"
  else
    echo "curl or wget required to download Maven. Please install one or install Maven manually." >&2
    exit 1
  fi

  # Extract
  rm -rf "$MAVEN_DIR"
  mkdir -p "$WRAPPER_DIR"
  tar -xzf "$TMPARCHIVE" -C "$WRAPPER_DIR"
  mv "$WRAPPER_DIR/apache-maven-$MAVEN_VERSION" "$MAVEN_DIR" 2>/dev/null || true
  rm -f "$TMPARCHIVE"
  chmod +x "$MAVEN_BIN"
fi

exec "$MAVEN_BIN" "$@"
