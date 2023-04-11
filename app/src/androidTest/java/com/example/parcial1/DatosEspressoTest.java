package com.example.parcial1;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.parcial1.BD.Dbdatos;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DatosEspressoTest {
    @Rule
    public ActivityScenarioRule<Datos> activityScenarioRule =
            new ActivityScenarioRule<>(Datos.class);

    @Before
    public void setUp() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            Dbdatos db = new Dbdatos(activity);
            db.deleteAllData(); // limpiamos la tabla de usuarios antes de cada prueba
        });
    }
    @Test
    public void testInsertData() {
        onView(withId(R.id.editnombre)).perform(typeText("Luis"), closeSoftKeyboard());
        onView(withId(R.id.editapellido)).perform(typeText("Valbuena"), closeSoftKeyboard());
        onView(withId(R.id.edittelefono)).perform(typeText("111"), closeSoftKeyboard());
        onView(withId(R.id.editedad)).perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.BtnGuardar)).perform(click());

    }

    @Test
    public void testInsertDataWithError() {
        // aquí se prueba el caso donde se ingresan datos inválidos y se espera un mensaje de error
        onView(withId(R.id.editnombre)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.editapellido)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.edittelefono)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.editedad)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.BtnGuardar)).perform(click());
    }
}
