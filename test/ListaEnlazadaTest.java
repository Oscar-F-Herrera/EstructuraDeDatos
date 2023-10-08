import org.junit.Assert;
import org.junit.Test;
import edu.oscar.herrera.utils.ListaEnlazada;

import java.util.Optional;

public class ListaEnlazadaTest {
    @Test
    public void add1ElementTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        Assert.assertEquals(Optional.of(5),lista.get(0));
        Assert.assertEquals(1,lista.size());
    }

    @Test
    public void add2Element2Test(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        lista.add(78);
        Assert.assertEquals(Optional.of(5),lista.get(0));
        Assert.assertEquals(Optional.of(78),lista.get(1));
        Assert.assertEquals(2,lista.size());
    }
    @Test
    public void getNegativeIndexTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        Assert.assertThrows(IndexOutOfBoundsException.class,()->lista.get(-1));
        Assert.assertEquals(1,lista.size());
    }

    @Test
    public void getIndexOutOfBoundsTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        Assert.assertThrows(IndexOutOfBoundsException.class,()->lista.get(1));
        Assert.assertEquals(1,lista.size());
    }

    @Test
    public void containsElementsTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        lista.add(78);
        Assert.assertTrue(lista.contains(78));
        Assert.assertTrue(lista.contains(5));
        Assert.assertEquals(2,lista.size());
    }

    @Test
    public void containsNotPResentElementsTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        lista.add(78);
        Assert.assertFalse(lista.contains(79));
    }

    @Test
    public void updateTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        lista.update(5,78);
        Assert.assertFalse(lista.contains(5));
        Assert.assertTrue(lista.contains(78));
    }


    @Test
    public void removeEmptyTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.remove(5);
        Assert.assertEquals(0,lista.size());
    }
    @Test
    public void removeRootTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        lista.add(78);
        lista.add(105);
        lista.remove(5);
        Assert.assertTrue(lista.contains(78));
        Assert.assertTrue(lista.contains(105));
        Assert.assertFalse(lista.contains(5));
        Assert.assertEquals(2,lista.size());
    }
    @Test
    public void removeMiddleTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        lista.add(78);
        lista.add(105);
        lista.remove(78);
        Assert.assertTrue(lista.contains(5));
        Assert.assertTrue(lista.contains(105));
        Assert.assertFalse(lista.contains(78));
        Assert.assertEquals(2,lista.size());
    }
    @Test
    public void removeLastTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        lista.add(78);
        lista.add(105);
        lista.remove(105);
        Assert.assertTrue(lista.contains(5));
        Assert.assertTrue(lista.contains(78));
        Assert.assertFalse(lista.contains(105));
        Assert.assertEquals(2,lista.size());
    }

    //pruebas para metodos addfirst y removefirst
    @Test
    public void addFirstTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.addFirst(5);
        lista.addFirst(78);
        lista.addFirst(105);
        Assert.assertTrue(lista.get(0).get()==105);
        Assert.assertFalse(lista.get(0).get()==5);
        Assert.assertEquals(3,lista.size());
    }

    @Test
    public void addFirst_and_add_Test(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.addFirst(5);
        lista.add(78);
        lista.addFirst(105);
        Assert.assertTrue(lista.get(0).get()==105);
        Assert.assertTrue(lista.get(1).get()==5);
        Assert.assertTrue(lista.get(2).get()==78);
        Assert.assertEquals(3,lista.size());
    }

    @Test
    public void removeFirstTest(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(5);
        lista.add(78);
        lista.add(105);
        lista.removeFirst();

        Assert.assertFalse(lista.contains(5));
        Assert.assertTrue(lista.get(0).get()==78);
        Assert.assertTrue(lista.get(1).get()==105);
        Assert.assertEquals(2,lista.size());
    }
}
