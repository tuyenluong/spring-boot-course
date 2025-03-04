package com.jeremy.repository;

import com.jeremy.model.Holiday;
import org.springframework.data.repository.CrudRepository;

public interface HolidaysRepository extends CrudRepository<Holiday, String> {
}
