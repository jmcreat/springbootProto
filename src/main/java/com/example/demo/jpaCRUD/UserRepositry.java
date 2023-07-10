package com.example.demo.jpaCRUD;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Long> {

}