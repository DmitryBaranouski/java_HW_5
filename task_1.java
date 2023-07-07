import java.util.*;

// Задание

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
// с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

// Пример меню:
// 1) Добавить контакт
// 2) Вывести всех
// 3) Выход

// Ярцев 151515
// Ярцев 261512
// Ярцев 758382

public class task_1 {

// -----  Метод sortedPrint() сортирует и распечатывает данные по абонентам -----
    static void sortedPrint(Map<String, ArrayList> map) {

        // Получаем набор всех ключей abon
        Set<String> keySet = map.keySet();

        // Находим минимальное и максимальное значение
        int maxCount = 0;
        int minCount = 1_000_000;
        
        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();
            
        }
        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {
            // System.out.println(map);
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }  
            }
            num += 1;
        }
        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Инициализация начального списка
        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Ярцевв", new ArrayList<Integer>() {
                    {
                        add(876787);
                        add(888876);
                        add(922381);
                    }
                });
                put("Феербах", new ArrayList<Integer>() {
                    {
                        add(123123);
                    }
                });
                put("Ярцев", new ArrayList<Integer>() {
                    {
                        add(838383);
                        add(232377);

                    }
                });
                put("Лукашенко", new ArrayList<Integer>() {
                    {
                        add(886644);
                        add(555222);
                        add(182830);
                        add(999999);
                    }
                });
            }
        };
        System.out.println();
        // Печатаем исходный набор данных
        System.out.println("Изначальные данные: ");
        sortedPrint(abon);

        // Создаем меню
        Scanner scan = new Scanner(System.in, "cp866");
        Boolean getOut = false;
        String st;
        while (!getOut) {
            System.out.println("Введите номер действия (1 - добавить абонента, 9 - выйти из программы):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "1": {
                    System.out.println("Введите фамилию абонента:");
                    name = scan.nextLine();
                    if (abon.containsKey(name)) {
                        System.out.println("Такая фамилия присутствуют!");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Введите номера телефонов через запятую: ");
                        phString = scan.nextLine();
                        String[] arr = phString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim())) ;
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }
                }
                case "9": {
                    getOut = true;
                    System.out.println();
                    System.out.println("Не так быстро как предполагалось? Ни чем не могу помочь!");
                    System.out.println();
                    break;
                }   
                    
               
            }
        }
    }

}