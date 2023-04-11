package com.example.assignment3.NewClass;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewSetTest extends TestCase {
    NewSet set=new NewSet();
    NewSet set2=new NewSet();

    Identifiable str=new Identifiable() {
        @Override
        public int getId() {
            return 5;
        }
    };

    @Test
    void testAdd() {
Boolean flag1=true;
Boolean flag2=true;
flag1=set.add(str);
flag2=set.add(str);

        if (flag1 == true && flag2 == false) {
            assert(true);
        }else{
            assert(false);
        }

    }

    @Test
    void testDelete() {
        Boolean flag=set.add(str);
        assertNotEquals(set.delete(str.getId()),null);
    }

    @Test
    void testPeek() {
        Boolean flag=set.add(str);
        assertEquals(set.peek(str.getId()),true);
    }

    @Test
    void testSize() {
        int size1=set.size();
        Boolean flag=set.add(str);
        int size2=set.size();

        if (size1 == 0 && size2 == 1) {
            assert(true);
        }else{
            assert(false);
        }
    }

    @Test
    void testEquals() {
        String name = "test";
        int id = 1;
        TestBase base1 = new TestBase(name, id);
        NewSet<TestBase> set1 = new NewSet<>();
        set1.add(base1);

        NewSet<TestBase> set2 = new NewSet<>();
        set2.add(base1);

        if(set1.equals(set2)){
            assert true;
        }else{
            assert false;
        }

    }

    @Test
    void testToString() {
        Boolean flag=set.add(str);
        set.toString();
        assert(true);
    }

    @Test
    void testDisplayElements() {
        Boolean flag=set.add(str);
        set.displayElements();
        assert(true);
    }
}