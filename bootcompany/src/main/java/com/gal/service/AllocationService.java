package com.gal.service;

import java.util.List;
import com.gal.model.AllocationData;
import com.gal.model.CabAllocation;

public interface AllocationService {
    List<CabAllocation> allocate(AllocationData allocData);
}