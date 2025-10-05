package com.chalow.rideshare.service.impl;

import com.chalow.rideshare.service.DataArchivalService;
import org.springframework.stereotype.Service;

@Service
public class SimpleDataArchivalService implements DataArchivalService {
    @Override
    public ArchivalStats getArchivalStats() { return new ArchivalStats(); }

    @Override
    public void archiveOldCompletedRides() { /* no-op */ }

    @Override
    public void deleteExpiredArchivedRecords() { /* no-op */ }
}
