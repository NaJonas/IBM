package com.navikas.Model;

import com.navikas.Entities.Object;
import com.navikas.Entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectRepository extends JpaRepository<Object, Long> {
}
