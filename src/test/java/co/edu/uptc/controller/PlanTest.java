package co.edu.uptc.controller;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import co.edu.uptc.model.Plan;
import co.edu.uptc.persistence.FilePersistence;

public class PlanTest {
    public static PlanController planController;
    public static FilePersistence<Plan> inFilePersistence;
    public static Plan p1;
    public static Plan p2;
    public static Plan p3;

    @Before
    public void setUp() {
        Type type = new TypeToken<ArrayList<Plan>>() {
        }.getType();

        inFilePersistence = new FilePersistence<>(type, "plans");
        planController = new PlanController(inFilePersistence);

        // create Files
        // inFilePersistence.createFile();

        p1 = new Plan(0, null, null, 0, 0);
        p2 = new Plan(1, "Basico", "un plan para toda la familia", 20000, 10);
        p3 = new Plan(1, "Basico", "un plan para toda la familia", 20000, 10);
    }

    @Test
    public void testMethods() {
        addPlanTest();
        deletePlanTest();
        getPlanTest();
        getAllPlanTest();
        updatePlanTest();
    }

    private void addPlanTest() {
        assertEquals(false, planController.add(p1));
        assertEquals(true, planController.add(p2));
        assertEquals(false, planController.add(p3));
        p3 = new Plan(2, "Especial", "plan super especial", 50000, 93);
        assertEquals(true, planController.add(p3));

    }

    private void deletePlanTest() {
        assertEquals(true, planController.delete(1));
        assertEquals(false, planController.delete(1));
        assertEquals(false, planController.delete(125));

    }

    private void getPlanTest() {
        assertEquals(p3.getId(), planController.get(2).getId());
        assertEquals(p3.getDescription(), planController.get(2).getDescription());
        assertEquals(null, planController.get(1));
        assertEquals(null, planController.get(55));

    }

    private void getAllPlanTest() {
        assertEquals(p3.getNamePlan(), planController.getAll().get(0).getNamePlan());
        assertEquals(1, planController.getAll().size());

    }

    private void updatePlanTest() {
        p1 = new Plan(3, "plan one", "este plan cuenta..", 25400, 30);
        assertEquals(true, planController.update(2, p1));
        assertEquals(null, planController.get(2));
        assertEquals(p1, planController.get(3));

    }

}
