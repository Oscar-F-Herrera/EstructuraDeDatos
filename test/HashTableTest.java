import com.sun.jdi.IntegerValue;
import edu.oscar.herrera.utils.collections.HashTable;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class HashTableTest {

    private HashTable<String, Integer> hashTable;

    @Before
    public void setUp() {
        hashTable = new HashTable<>(); // Crea un HashTable antes de cada prueba
    }

    @Test
    public void testSize() {
        assertEquals(0, hashTable.size()); // Verifica que el tamaño sea 0 al principio
        hashTable.add("Uno", 1);
        assertEquals(1, hashTable.size()); // Verifica que el tamaño sea 1 después de agregar
                                                    // un elemento
        hashTable.add("Dos", 2);
        hashTable.add("Tres", 3);
        hashTable.add("Cuatro", 4);
        hashTable.add("Cinco", 5);
        hashTable.add("Seis", 6);
        hashTable.add("Siete", 7);
        hashTable.add("Ocho", 8);
        hashTable.add("Nueve", 9);
        assertEquals(9, hashTable.size()); // Verifica que el tamaño sea 9 después de agregar
                                                    // más elementos
    }

    @Test
    public void testEmpty() {
        assertEquals(true, hashTable.isEmpty()); // Verifica que la tabla esté vacía
        hashTable.add("Uno", 1);
        assertEquals(false, hashTable.isEmpty()); // Verifica que la tabla no esté vacía
    }

    @Test
    public void testAddAndGet() {
        hashTable.add("Uno", 1);
        assertEquals(Integer.valueOf(1), hashTable.get("Uno")); // Verifica que se pueda obtener
                                                                   // el valor correcto
    }

    @Test
    public void testGetValues() {
        hashTable.add("Uno", 1);
        hashTable.add("Dos", 2);
        hashTable.add("Tres", 3);
        hashTable.add("Cuatro", 4);
        hashTable.add("Cinco", 5);
        assertEquals(5, hashTable.getValues().size()); // Verifica que se devuelva la cantidad de
                                                                // valores correcta
        System.out.println(hashTable.getValues()); // Imprime los valores de la tabla
    }
}