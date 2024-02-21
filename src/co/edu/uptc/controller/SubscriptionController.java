package co.edu.uptc.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uptc.model.Subscription;
import co.edu.uptc.persistence.Persistence;

public class SubscriptionController {

    Persistence<Subscription> persistence;

    public SubscriptionController() {
    }

    public SubscriptionController(Persistence<Subscription> persistence) {
        this.persistence = persistence;
    }

    public boolean add(Subscription subscription) {
        if (subscription.getPlan() != null && subscription.getUser() != null && setStartDate(subscription)
                && setEndDate(subscription)) {
            return persistence.persist(subscription);
        } else {
            return false;
        }

    }

    public boolean delete(int id) {
        return persistence.erase(id);
    }

    public Subscription get(int id) {
        return persistence.obtainById(id);
    }

    public ArrayList<Subscription> getAll() {
        return persistence.obtainAll();
    }

    public boolean update(int id, Subscription newsubscription) {
        Subscription currentSubscription = get(id);
        if (currentSubscription != null) {
            int index = getAll().indexOf(currentSubscription);
            return this.persistence.persist(index, newsubscription);
        } else {
            return false;
        }
    }

    public boolean setStartDate(Subscription subscription) {
        subscription.setDateStart(LocalDate.now());
        if (subscription.getDateStart() != null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean setEndDate(Subscription subscription) {
        LocalDate findEndDate;
        if (subscription != null && subscription.getDateStart() != null) {
            findEndDate = subscription.getDateStart().plusDays(subscription.getPlan().getDuration());
            subscription.setDateEnd(findEndDate);
            return true;
        } else {
            return false;
        }
    }

}