package com.baeldung;

import com.baeldung.hibernate.HibernateAnnotationUtil;
import com.baeldung.models.Cart;
import com.baeldung.models.Item;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
class HibernateTest {

    @Test
    void givenSessionContext_whenSave_thenOK() {
        Cart cart = new Cart();
        Item item = new Item("item1");
        Item item2 = new Item("item2");
        item.setCart(cart);
        item2.setCart(cart);
        cart.getItems().addAll(Arrays.asList(item, item2));
        Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cart);
        session.save(item);
        transaction.commit();
        session.close();
        log.info("THE END");
    }

}
