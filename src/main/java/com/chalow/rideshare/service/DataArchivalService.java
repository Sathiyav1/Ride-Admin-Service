package com.chalow.rideshare.service;

public interface DataArchivalService {
    class ArchivalStats {
        public long getActiveRideRequests() { return 0; }
        public long getActiveRideOffers() { return 0; }
        public long getActiveRides() { return 0; }
        public long getArchivedRideRequests() { return 0; }
        public long getArchivedRideOffers() { return 0; }
        public long getArchivedRides() { return 0; }
        public long getRecordsScheduledForDeletion() { return 0; }
        public long getRecentlyArchivedCount() { return 0; }
    }

    ArchivalStats getArchivalStats();
    void archiveOldCompletedRides();
    void deleteExpiredArchivedRecords();
}
