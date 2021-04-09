package org.yun.heartcheck.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.yun.heartcheck.model.Url;

import java.util.List;

public interface UrlRepository extends CrudRepository<Url, String> {

    void deleteUrlByIdIn(List<String> idList);

    @Modifying
    @Query("update Url url set url.status = ?2 where url.id = ?1")
    int updateTask(String id, String status);
}
