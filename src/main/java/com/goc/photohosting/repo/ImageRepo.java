package com.goc.photohosting.repo;

import com.goc.photohosting.model.Image;
import com.goc.photohosting.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
