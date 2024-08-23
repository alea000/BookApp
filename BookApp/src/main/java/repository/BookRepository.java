package repository;

import Model.Book;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
//jpa provides implementation for crud ops
}
