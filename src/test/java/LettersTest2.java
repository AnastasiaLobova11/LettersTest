import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

class LettersTest2 {

    Letters col;

    public LettersTest2() {
    }


    // метод size() для пустого конструктора
    @Test
    public void testEmptySize1() {
        col = new Letters();
        Assertions.assertEquals(0, col.size());
    }

    //метод size() для конструктора, принимающего пустую строку
    @Test
    public void testEmptySize2() {
        col = new Letters("");
        Assertions.assertEquals(0, col.size());
    }

    //метод size() для конструктора, принимающего строку из 5 символов
    @Test
    public void testSize1() {
        col = new Letters("12345");
        Assertions.assertEquals(5, col.size());
    }

    //метод size() для конструктора, принимающего строку из 1 символа
    @Test
    public void testSize2() {
        col = new Letters("1");
        Assertions.assertEquals(1, col.size());
    }

    //метод add(), добавляющий к непустой строке 1 символ
    @Test
    public void testAdd1() {
        col = new Letters("qw");
        col.add('1');
        Assertions.assertEquals("qw1", col.toString());
        Assertions.assertEquals(3, col.size());
    }

    //метод add(), добавляющий к созданному экзмепляру, созданного пустым конструктором,1 символ
    @Test
    public void testAdd2() {
        col = new Letters();
        col.add('1');
        Assertions.assertEquals("1", col.toString());
        Assertions.assertEquals(1, col.size());
    }

    //метод add(), добавляющий к созданному экзмепляру, созданного конструктором из пустой строки, 1 символ
    @Test
    public void testAdd3() {
        col = new Letters("");
        col.add('1');
        Assertions.assertEquals("1", col.toString());
        Assertions.assertEquals(1, col.size());
    }

    //метод add(), добавляющий к созданному экзмепляру, созданного конструктором из длинной строки, символ
    //для изменения размера внуреннего массива
    @Test
    public void testAdd4() {
        col = new Letters("knfklKK193");
        col.add(' ');
        Assertions.assertEquals("knfklKK193 ", col.toString());
        Assertions.assertEquals(11, col.size());
    }

    //метод contains(), проверяющий содержит ли экземляр, созданный из пустого конструктора, данный символ
    @Test
    public void testContains1() {
        col = new Letters();
        Assertions.assertEquals(false, col.contains('1'));
    }

    //метод contains(), проверяющий содержит ли экземляр, созданный конструктором из пустой строки, данный символ
    @Test
    public void testContains2() {
        col = new Letters("");
        Assertions.assertEquals(false, col.contains('1'));
    }

    //метод contains(), проверяющий содержит ли экземляр, созданный из конструктора со строкой, данные символы
    @Test
    public void testContains3() {
        col = new Letters("12345");
        Assertions.assertEquals(true, col.contains('1'));
        Assertions.assertEquals(true, col.contains('3'));
        Assertions.assertEquals(true, col.contains('5'));
        Assertions.assertEquals(false, col.contains('0'));
    }

    //метод contains(), проверяющий содержит ли экземляр, созданный из 1 символа, заданные символы
    @Test
    public void testContains4() {
        col = new Letters("1");
        Assertions.assertEquals(true, col.contains('1'));
        Assertions.assertEquals(false, col.contains('0'));
    }

    //метод addAll(), проверяющие добавление всех элементов одной строки,не содержащей символы из 1 строки, к другой
    @Test
    public void testAddAll1() {
        col = new Letters("qw");
        col.addAll(new Letters("123"));
        Assertions.assertEquals("qw123", col.toString());
        Assertions.assertEquals(5, col.size());
    }

    //метод addAll(), проверяющие добавление всех элементов одной строки,содержащей символы из 1 строки, к другой
    @Test
    public void testAddAll2() {
        col = new Letters();
        col.addAll(new Letters("123"));
        Assertions.assertEquals("123", col.toString());
        Assertions.assertEquals(3, col.size());
    }

    //метод addAll(), проверяющие добавление всех элементов одной строки к пустой строке
    @Test
    public void testAddAll3() {
        col = new Letters("");
        col.addAll(new Letters("123"));
        Assertions.assertEquals("123", col.toString());
        Assertions.assertEquals(3, col.size());
    }

    //метод addAll(), проверяющие добавление всех элементов одной строки к элементу, созданного из пустого конструктора
    @Test
    public void testAddAll4() {
        col = new Letters();
        col.addAll(new Letters("123"));
        Assertions.assertEquals("123", col.toString());
        Assertions.assertEquals(3, col.size());
    }

    @Test
    public void testAddAll5() {
        col = new Letters("0123456789");
        col.addAll(new Letters("00123456789"));
        Assertions.assertEquals("012345678900123456789", col.toString());
        Assertions.assertEquals(21, col.size());
    }

    //метод clear(), удаляющий все элементы непустой строки
    @Test
    public void testClear() {
        col = new Letters("qw");
        col.clear();
        Assertions.assertEquals(0, col.size());
    }

    //метод clear(), удаляющий все элементы строки, созданной из пустого конструтора
    @Test
    public void testClear0() {
        col = new Letters();
        col.clear();
        Assertions.assertEquals(0, col.size());
    }

    //метод clear(), удаляющий все элементы строки, созданной из пустой строки
    @Test
    public void testClear1() {
        col = new Letters("");
        col.clear();
        Assertions.assertEquals(0, col.size());
    }

    //instanceof, проверяет, что первый элемент из нашей коллекции- Character
    @Test
    public void testLettersType() {
        col = new Letters("12345");
        if (!(col.iterator().next() instanceof Character)) {
            Assertions.fail("Returned value is not a Character");
        }
    }

    //IteratorNext, проверяет метод next() в непустом экзмепляре
    @Test
    public void testIteratorNext() {
        Iterator<Character> cl = new Letters("123").iterator();
        Assertions.assertEquals("1", cl.next().toString());
        Assertions.assertEquals("2", cl.next().toString());
        Assertions.assertEquals("3", cl.next().toString());
    }

    //IteratorNext, проверяет метод next() в экзмепляре, созданным из конструктора с пустой строкой
    @Test
    public void testIteratorNextException() {
        Iterator<Character> cl = new Letters("").iterator();
        Assertions.assertThrows(Exception.class,()->{
            cl.next().toString();
        });
    }

    //IteratorNext, проверяет метод next() в экзмепляре, созданным из конструктора с пустого конструктора
    @Test
    public void testIteratorNextException1() {
        Iterator<Character> cl = new Letters().iterator();
        Assertions.assertThrows(Exception.class,()->{
            cl.next().toString();
        });
    }

    //IteratorNext, проверяет метод next() на выход за пределы и ввыбрасывает исключение
    @Test
    public void testIteratorException() {
        Iterator<Character> cl = new Letters("12").iterator();
        Assertions.assertThrows(Exception.class,()->{
            Assertions.assertEquals("1", cl.next().toString());
            Assertions.assertEquals("2", cl.next().toString());
            cl.next();
        });
    }

    //IteratorHasNext, проверяет метод  hasNext() для экзепляра из 1 символа
    @Test
    public void testIteratorHasNext1() {
        Iterator <Character> cl = new Letters("1").iterator();
        Assertions.assertEquals(true, cl.hasNext());
        cl.next();
        Assertions.assertEquals(false, cl.hasNext());
    }

    //IteratorHasNext, проверяет метод  hasNext() для экзепляра из пустого конструктора
    @Test
    public void testIteratorHasNext2() {
        Iterator <Character> c2 = new Letters().iterator();
        Assertions.assertEquals(false, c2.hasNext());
    }

    //IteratorHasNext, проверяет метод  hasNext() для экзепляра из пустой строки
    @Test
    public void testIteratorHasNext3() {
        Iterator <Character> c2 = new Letters("").iterator();
        Assertions.assertEquals(false, c2.hasNext());
    }

    @Test
    //IteratorClear, очищает наш экзмепляр и пробует вызвать next(), но получется ошибку
    public void testIteratorClear1() {
        col =new Letters("123");
        Iterator <Character> cl = col.iterator();
        Assertions.assertEquals(true, cl.hasNext());
        col.clear();
        Assertions.assertThrows(Exception.class,()->{
            cl.next();
        });
    }

    //TwoIterators, проверяет на совместное использование 2х итератором для одного экзмепляра
    @Test
    public void testTwoIterators() {
        col = new Letters("123");
        Iterator <Character> c1 = col.iterator();
        Iterator <Character> c2 = col.iterator();
        Assertions.assertEquals( c1.hasNext(), c2.hasNext());
        Assertions.assertEquals("1", c1.next().toString());
        Assertions.assertEquals("1", c2.next().toString());
        c1.next();
        Assertions.assertEquals("3", c1.next().toString());
        Assertions.assertEquals("2", c2.next().toString());
        Assertions.assertTrue ( c2.hasNext());
        Assertions.assertFalse( c1.hasNext());
    }

    //DoubleUsing, двойной проход по списку
    @Test
    public void testDoubleUsing() {
        col = new Letters("12345");
        int i = 0;
        for (Object c : col) {
            i++;
        }
        for (Object c : col) {
            i++;
        }
        Assertions.assertEquals(10, i);
    }


    //removeAll, удаляет из заданного экземпляра все совпадения с другим экземпляром, оставляя не совпадающие элеемнты
    @Test
    public void testRemoveAll() {
        col = new Letters("142345");
        col.removeAll(new Letters("4"));
        Assertions.assertEquals("1235", col.toString());
    }

    //removeAll, удаляет из заданного экземпляра все совпадения с другим экземпляром,
    //учитывая то,что во 2 есть все элементы первого
    @Test
    public void testRemoveAll1() {
        col = new Letters("444");
        col.removeAll(new Letters("4"));
        Assertions.assertEquals(0, col.size());
    }

    //removeAll, удаляет из заданного экземпляра все совпадения с другим экземпляром,
    //учитывая критические ситуации(удаление из начала/конца)
    @Test
    public void testRemoveAll2() {
        col = new Letters("414243");
        col.removeAll(new Letters("4"));
        Assertions.assertEquals("123", col.toString());
    }

    //removeAll, пытается удалить если нет совпадений
    @Test
    public void testRemoveAll3() {
        col = new Letters("414243");
        col.removeAll(new Letters("5"));
        Assertions.assertEquals("414243", col.toString());
    }

    //remove, удаляет первый встретившийся символ, совпавший с указанным
    @Test
    public void testRemove() {
        col = new Letters("142345");
        col.remove('4');
        Assertions.assertEquals("12345", col.toString());
    }

    //remove, не удаляет символ,так как ни одни не совпал с указанным
    @Test
    public void testRemove1() {
        col = new Letters("142345");
        col.remove('9');
        Assertions.assertEquals("142345", col.toString());
    }

    //remove, не удаляет символ,так как экземпляр создан из пустой строки
    @Test
    public void testRemove2() {
        col = new Letters("");
        col.remove('4');
        Assertions.assertEquals("", col.toString());
    }

    //remove, не удаляет символ,так как экземпляр создан из пустого конструктора
    @Test
    public void testRemove3() {
        col = new Letters();
        col.remove('4');
        Assertions.assertEquals("", col.toString());
    }

    //remove, удаляет символ в экземпляре, где рядом находятся 2 одинаковых необходимых символа
    @Test
    public void testRemove4() {
        col = new Letters("444414");
        col.remove('4');
        Assertions.assertEquals("44414", col.toString());
        Assertions.assertEquals(5,col.size());
    }

    //remove, удаляет символ в экземпляре, где рядом находятся только этот элемент
    @Test
    public void testRemove5() {
        col = new Letters("4");
        col.remove('4');
        Assertions.assertEquals("", col.toString());
        Assertions.assertEquals(0,col.size());
    }

    //IteratorRemove, вызываем метод next(),а после remove()
    @Test
    public void testIteratorRemove() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        cl.next();
        cl.remove();
        Assertions.assertEquals("23", col.toString());
    }

    //IteratorRemove, вызываем два раза метод next(),а после remove()
    @Test
    public void testIteratorRemove1() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        cl.next();
        cl.next();
        cl.remove();
        Assertions.assertEquals("13", col.toString());
        Assertions.assertEquals(2, col.size());
    }

    //IteratorRemove, вызываем три раза метод next(),а после remove()
    @Test
    public void testIteratorRemove2() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        cl.next();
        cl.next();
        cl.next();
        cl.remove();
        Assertions.assertEquals("12", col.toString());
        Assertions.assertEquals(2, col.size());
    }

    //IteratorRemove,корректно удаляем первые 2 символа
    @Test
    public void testIteratorRemove3() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        cl.next();
        cl.remove();
        cl.next();
        cl.remove();
        Assertions.assertEquals("3", col.toString());
        Assertions.assertEquals(1, col.size());
    }

    //IteratorRemove,корректно удаляем все символы
    @Test
    public void testIteratorRemove4() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        cl.next();
        cl.remove();
        cl.next();
        cl.remove();
        cl.next();
        cl.remove();
        Assertions.assertEquals("", col.toString());
        Assertions.assertEquals(0, col.size());
    }

    //IteratorRemove,корректно удаляем символы внутри строки
    @Test
    public void testIteratorRemove5() {
        col = new Letters("12345");
        Iterator<Character> cl = col.iterator();
        cl.next();
        cl.next();
        cl.remove();
        cl.next();
        cl.remove();
        Assertions.assertEquals("145", col.toString());
        Assertions.assertEquals(3, col.size());
    }

    //IllegalIteratorRemove, пытаемся вызвать remove() без next()
    @Test
    public void testIllegalIteratorRemove() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        Assertions.assertThrows(Exception.class,()->{
            cl.remove();
        });
    }

    //IteratorRemove,пытаемся вызвать remove() без next() и проверяем не изминилась ли длина строки
    @Test
    public void testIllegalIteratorRemove1() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        try {
            cl.remove();
            Assertions.fail("Remove without next");
        } catch (Exception e) {

        }
        Assertions.assertEquals(3, col.size());
        cl.next();
        cl.remove();
        Assertions.assertEquals(2, col.size());
        try {
            cl.remove();
            Assertions.fail("Remove without next");
        } catch (Exception e) {
            Assertions.assertEquals(2, col.size());
        }

    }

    //IteratorRemove,сначала 2 next(), в затем 2 remove() подряд
    @Test
    public void testIllegalIteratorRemove2() {
        col = new Letters("12345");
        Iterator<Character> cl = col.iterator();
        Assertions.assertThrows(Exception.class,()->{
            cl.next();
            cl.next();
            cl.remove();
            cl.remove();
        });
    }

    //IteratorRemove,пытаемся вызвать remove(), когда вышли за гранцы
    @Test
    public void testIllegalIteratorRemove3() {
        col = new Letters("1");
        Iterator<Character> cl = col.iterator();
        Assertions.assertThrows(Exception.class,()->{
            cl.next();
            cl.next();
            cl.remove();
        });
    }

    //IteratorRemove,пытаемся вызвать remove(), когда экземпляр пуст
    @Test
    public void testIllegalIteratorRemove4() {
        col = new Letters("");
        Iterator<Character> cl = col.iterator();
        Assertions.assertThrows(Exception.class,()->{
            cl.remove();
        });
    }

    //retainAll(), выделяет совпадение из 2х непустых строк
    @Test
    public void testCorrectRetain0() {
        col = new Letters("qwerty");
        col.retainAll(new Letters("bgtredcv"));
        Assertions.assertEquals("ert", col.toString());
    }

    //retainAll(), выделяет совпадение из 2х непустых строк с повторяющимися элементами
    @Test
    public void testCorrectRetain1() {
        col = new Letters("qwertyqwrtye");
        col.retainAll(new Letters("bgtredcv"));
        Assertions.assertEquals("ertrte", col.toString());
    }

    //retainAll(), выделяет совпадение из 2х непустых несовпадающих строк
    @Test
    public void testCorrectRetain2() {
        col = new Letters("afasa");
        col.retainAll(new Letters("bgtredcv"));
        Assertions.assertEquals("", col.toString());
    }

    @Test
    public void testCorrectRetain3() {
        col = new Letters("");
        col.retainAll(new Letters("bgtredcv"));
        Assertions.assertEquals("", col.toString());
    }

    @Test
    public void testCorrectRetain4() {
        col = new Letters("afasa");
        col.retainAll(new Letters(""));
        Assertions.assertEquals("", col.toString());
    }

}