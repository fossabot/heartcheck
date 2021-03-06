package org.yun.heartcheck.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.yun.heartcheck.model.Url;

public interface UrlRepository extends CrudRepository<Url, String> {
}
