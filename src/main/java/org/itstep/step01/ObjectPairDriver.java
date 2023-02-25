package org.itstep.step01;

/**
 * Класс для тестирования кортежа ObjectPair
 *
 * @author Nathan Sprague
 * @version V1, 8/2016
 */
public class ObjectPairDriver {

    /**
     * Создайте несколько пар стадионов, затем распечатайте название стадиона с наибольшей вместимостью.
     *
     * @param args Не используется
     */
    public static void main(String[] args) {

        ObjectPair[] stadiums = new ObjectPair[5];
        stadiums[0] = new ObjectPair("Bridgeforth Stadium", 25000);
        stadiums[1] = new ObjectPair("Michigan Stadium", 109901);
        stadiums[2] = new ObjectPair("Lane Stadium", "66,233");
        stadiums[3] = new ObjectPair("Lane II Stadium", "112266,233");
        stadiums[4] = new ObjectPair("Lane III Stadium", "99112266.233asdfg");

        System.out.println(stadiums[0]);

        System.out.println(largestStadium(stadiums));
    }

    /**
     * Возвращает название стадиона с наибольшей вместимостью.
     *
     * @param stadiums Массив ObjectPairs, где каждая пара содержит название стадиона, за которым следует целое число
     * @return Название стадиона с наибольшей вместимостью
     */
    public static String largestStadium(ObjectPair[] stadiums) {
        // TODO: реализуйте это метод в соответствии с комментариями
        if (stadiums.length == 1) return stadiums[0].getSecond().toString();

        ObjectPair result = stadiums[0];
        for (ObjectPair stadium : stadiums) {
            if (getValue(stadium.getSecond()) > getValue(result.getSecond())) {
                result = stadium;
            }
        }
        return result.getFirst().toString();
    }

    private static Integer getValue(Object value) {
        if (value.getClass() == Integer.class) {
            return (Integer) value;
        } else if (value.getClass() == String.class) {
            String str;
            if(isNumeric((str = (String) value))) {
                str = str.replace(",", ".");
                    return Math.round(Float.parseFloat(str));
                }
            }
        return -1;
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.,]+");
    }
}
