package org.exercise.java.spring_la_mia_pizzeria_security.repository;

import org.exercise.java.spring_la_mia_pizzeria_security.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
