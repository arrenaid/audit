package com.rstyle.audit.repository;

import com.rstyle.audit.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {
    List<ClientEntity> findByFirstNameContainingIgnoreCase(String firstName);
    List<ClientEntity> findByLastNameContainingIgnoreCase(String lastName);
    //List<ClientEntity> findByTypeDocContainingIgnoreCase(int typeDoc);
    List<ClientEntity> findByNumberDocContainingIgnoreCase(String numberDoc);
    List<ClientEntity> findBySeriesDocContainingIgnoreCase(String seriesDoc);
}

//package ru.msocialproduction.test.zkrtbot.repository;
//
//        import org.springframework.data.jpa.repository.JpaRepository;
//        import ru.msocialproduction.test.zkrtbot.entity.Users;
//
//public interface UsersRepository extends JpaRepository<Users,Integer> {
//    Users findUserByChatId(Integer chatId);
//}