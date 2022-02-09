package com.tsi.sjumbe.demo;

import org.springframework.data.repository.CrudRepository;
public interface LanguageRepository extends CrudRepository<Language, Integer>{
//Integer needed for handling elements in the table (via the unique identifier)
}
