package tasks1;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tasks1 extends javax.swing.JFrame {

    private DefaultTableModel tm = new DefaultTableModel();
    private DefaultTableModel tm1 = new DefaultTableModel();
    private DefaultTableModel tm2 = new DefaultTableModel();
    String fileName = "";

    public void Task7P1() {
        int[] myList = new int[10];
        // Создаем случайные числа от -100 до 100 и выводим сам массив
        for (int i = 0; i < myList.length; i++) {
            myList[i] = 100 - (int) (Math.random() * 200 + 1);
        }
        lblOutList7P1.setText(Arrays.toString(myList) + " ");
        // Находим ср. арифметическое положительных чисел и выводим
        int k = 0;
        int totalPos = 0;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] > 0) {
                totalPos += myList[i];
                k++;
            }
        }
        if (k > 0) {
            lblOutSrArif7.setText(totalPos / k + "");
        }
        // Находим ср. арифметическое отрицательных чисел и выводим
        int e = 0;
        int totalDis = 0;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] < 0) {
                totalDis += myList[i];
                e++;
            }
        }
        if (e > 0) {
            lblOutSrArifmDis7.setText(totalDis / e + "");
        }
        // Находим количество нулей 
        int nulls = 0;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] == 0) {
                nulls++;
            }
        }
        lblCountNulls7.setText(nulls + "");
    }

    public void Task32P1() {
        int[] myList = new int[20];//Задаем массив размерности 20
        // Создаем случайные числа массиву от -100 до 100 и выводим его
        for (int i = 0; i < myList.length; i++) {
            myList[i] = 100 - (int) (Math.random() * 200 + 1);
        }
        lblOutArray32P1.setText(Arrays.toString(myList) + "");
        // Находим максимальное число среди отрицательных
        int max = -1000;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] < 0 & max < myList[i]) {
                max = myList[i];
            }
        }
        lblOutMaxDis32P1.setText(max + "");
    }

    public void Task57P1() {
        //Массив
        int[] myList = new int[12];
        //Создание элементов для массива и его вывод 
        for (int i = 0; i < myList.length; i++) {
            myList[i] = (int) (Math.random() * 10 + 1);
        }
        lblOutArray57P1.setText(Arrays.toString(myList));
        int total = 0;//Переменная для подсчета общей суммы продаж
        //Цикл для сложения всех элементов массива в переменную total
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        //Вывод общей суммы продаж за 12 месяцев
        lblOutSumm57P1.setText(total + "  Среднее за год: " + total / 12);
        //Цикл для подсчета номера элемента(т.е. месяцев) и вывод
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] > (total / myList.length)) {
                lblOutNumElem57P1.setText(lblOutNumElem57P1.getText() + (i + 1) + " ");
            }
        }
        //Цикл для нахождения общей суммы продажи за 1 полугодие
        int sum1 = 0;
        for (int i = 0; i < 6; i++) {
            sum1 += myList[i];
        }
        //Цикл для нахождения общей суммы продажи за 2 полугодие
        int sum2 = 0;
        for (int i = 7; i < myList.length; i++) {
            sum2 += myList[i];
        }
        //Вывод в какое полугодие было большее количество продаж
        if (sum1 > sum2) {
            lblOutCountWork57P1.setText("В первое: " + sum1);
        } else {
            lblOutCountWork57P1.setText("Во второе: " + sum2);
        }
    }

    public void Task7P2() {
        if (txtfInputRowT7P2.getText().isEmpty() || txtfInputColT7P2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Поле пусто, введите значения!");
        } else {//Выполняется, если поле не пустое
            tm = (DefaultTableModel) tblListT7P2.getModel();//Создание стандартной модели листа
            int row = Integer.parseInt(txtfInputRowT7P2.getText());//Принимает значение количества строк
            int col = Integer.parseInt(txtfInputColT7P2.getText());//Значение количества столбцов
            tm.setColumnCount(col);//Устанавливает для таблицы количество столбцов
            //Массивы для исх.матрицы и матриц вывода ответа
            int[][] List = new int[row][col];
            int[] ListMax = new int[col];
            int[] ListMin = new int[row];

            int max;//Переменная для подсчета максимума
            int min;//Переменная для подсчета минимума
            //Цикл для создания элементов матрицы и вывода её в таблицу
            for (int i = 0; i < row; i++) {
                Vector vr = new Vector();
                for (int j = 0; j < col; j++) {
                    List[i][j] = (int) (Math.random() * 100 + 1);
                    vr.add(List[i][j]);
                }
                tm.addRow(vr);
            }
            //Цикл для нахождения макс. элемента в столбце и мин. в строке
            max = -1000;
            min = 1000;
            for (int j = 0; j < col; j++) {
                for (int i = 0; i < row; i++) {
                    if (max < List[i][j]) {
                        max = List[i][j];
                        ListMax[j] = max;
                    }
                    if (min > List[j][i]) {
                        min = List[j][i];
                        ListMin[j] = min;
                    }
                }
                max = -1000;
                min = 1000;
            }
            //Вывод массивов для вывода
            lblOutAnswerT7P2p1.setText(Arrays.toString(ListMax));
            lblOutAnswerT7P2p2.setText(Arrays.toString(ListMin));
        }
    }

    public void Task32P2() {
        if (txtfInputCT32P2.getText().isEmpty() || txtfInputRT32P2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Поле пусто, введите значения!");
        } else {//Выполняется, если поле не пусто
            //Модели для вывода в таблицы
            tm = (DefaultTableModel) tblListT32P2.getModel();
            tm1 = (DefaultTableModel) tblOutMaxT32P2.getModel();
            tm2 = (DefaultTableModel) tblOutMinT32P2.getModel();
            //Преобразование вписанных значений в количество строк и столбцов матрицы
            int row = Integer.parseInt(txtfInputRT32P2.getText());
            int col = Integer.parseInt(txtfInputCT32P2.getText());
            //Переменные для подсчета размерности одномерн.массивов minArray и maxArray
            int min_i = 1;
            int max_i = 1;
            //Установка количества столбцов в таблицы
            tm.setColumnCount(col);
            tm1.setColumnCount(col);
            tm2.setColumnCount(col);
            //Создание массивов
            int[][] List = new int[row][col];
            int[] maxArray = new int[col];
            int[] minArray = new int[col];
            int max;//Переменная для подсчета максимума
            int min;//Переменная для подсчета минимума
            //Цикл для создания элементов матрицы и вывода в таблицу
            for (int i = 0; i < row; i++) {
                Vector vr = new Vector();
                for (int j = 0; j < col; j++) {
                    List[i][j] = 30 + (int) (Math.random() * 40 + 1);
                    System.out.print(" " + List[i][j] + " ");
                    vr.add(List[i][j]);
                }
                System.out.println();
                tm.addRow(vr);
            }
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            int nCol = 1;//Номер столбца
            //Цикл для добавление значений в массив minArray и maxArray
            for (int j = 0; j < col; j++) {
                for (int i = 0; i < row; i++) {
                    if ((min > List[i][j]) & (nCol % 2 == 0)) {
                        min = List[i][j];
                        minArray[min_i] = min;
                    }
                    if ((max < List[i][j]) & (nCol % 2 != 0)) {
                        max = List[i][j];
                        maxArray[max_i] = max;
                    }
                }
                nCol++;
                if (j % 2 == 0 & minArray[min_i] != 0) {
                    min_i++;
                }
                if (j % 2 != 0 & maxArray[max_i] != 0) {
                    max_i++;
                }
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
            }

            //Вывод в таблицы Max и Min
            System.out.println("Max:");
            System.out.println(Arrays.toString(maxArray));
            System.out.println("Min:");
            System.out.println(Arrays.toString(minArray));
            //Переменные для цикла, который убирает нули в массивах для вывода ответа
            int len = 0;
            int len1 = 0;
            //Цикл, который считает количество ненулевых чисел
            for (int i = 0; i < minArray.length; i++) {
                if (minArray[i] != 0) {
                    len++;
                }
            }
            //Цикл, который считает количество ненулевых чисел
            for (int i = 0; i < maxArray.length; i++) {
                if (maxArray[i] != 0) {
                    len1++;
                }
            }
            int[] newMinArray = new int[len];//Новый массив минимумов без нулей
            int[] newMaxArray = new int[len1];//Новый массив максимумов без нулей
            //Цикл, который убирает нули для первого массива
            for (int i = 0, j = 0; i < maxArray.length; i++) {
                if (minArray[i] != 0) {
                    newMinArray[j] = minArray[i];
                    j++;
                }
            }
            //Цикл, который убирает нули для второго массива
            for (int i = 0, j = 0; i < minArray.length; i++) {
                if (maxArray[i] != 0) {
                    newMaxArray[j] = maxArray[i];
                    j++;
                }
            }
            //Вывод массивов в лист        
            Vector vr1 = new Vector();
            Vector vr2 = new Vector();
            for (int i = 0; i < newMinArray.length; i++) {
                vr1.add(newMaxArray[i]);
                vr2.add(newMinArray[i]);
            }
            tm1.addRow(vr1);
            tm2.addRow(vr2);
        }
    }

    public void Task7P3() {
        if (txtfInputStringTask7P3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Поле пустое, введите текст!");
        } else {//Выполняется, если поле не пустое
            DefaultListModel<String> list1 = new DefaultListModel();//Создание стандартной модели Листа
            String str = txtfInputStringTask7P3.getText();//Принимает строку
            String[] outStr = str.split("@");//Разделяет на строки по сигналу "@"
            //Цикл для заполнения модели листа, а после её вывода
            for (int i = 0; i < outStr.length; i++) {
                list1.addElement(outStr[i]);
            }
            listOutTask7P3.setModel(list1);
        }

    }

    public void Task32P3() {
        if (txtfTask32P3Input.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Поле пустое, введите текст!");
        } else {//Выполняется, если поле не пустое
            String str = txtfTask32P3Input.getText();//Принимает строку
            String newStr = "";//Переменная, которая принимает измененную строку
            //Замещает 5 на 65 и выводит в лейбл, если поле не пустое
            if (str.contains("5")) {
                newStr = str.replace("5", "65");
            }
            lblOutAnswerT32P3.setText(newStr);
        }

    }

    public void Task57P3() {
        if (txtfInputTextT57P3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Поле пусто, введите значения!");
        } else {//Выполняется, если поле не пустое
            String str = txtfInputTextT57P3.getText();//Принимает введенную строку
            int count = 0;//Счетчик для символов(будет выводиться)
            char[] charArray = str.toCharArray();//Преобразуем в массив char
            //Вывод в консоль символов с кодами от 0-135
            char ch = 0;
            for (int i = 0; i < 135; i++) {
                System.out.print(ch);
                ch++;
            }
            //Счетчик с условием и его вывод
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] >= 70) {
                    count++;
                }
            }
            lblOutputAnswerT57P3.setText(count + "");
        }
    }

    public void Task32P4() {
        //Стандартная модель листа для вывода работников
        DefaultListModel<String> list1 = new DefaultListModel();
        Worker[] array = new Worker[10];

        String[] names = {"Alex", "Egor", "Vlad", "Oleg", "Clara",
            "Danil", "Kolya", "Misha", "Anton", "Artem"};
        String[] surnames = {"Vladimirov", "aleksandrov",
            "Alexeev", "Kalashnikov",
            "Antonov", "Monitorov",
            "Rutin", "Morjov",
            "Kuznecov", "Molkov"};
        String[] patronymic = {"Vladimirovich", "aleksandrovich",
            "Alexeevich", "Kalashnikovich",
            "Antonovich", "Monitorovich",
            "Rutinovich", "Morjovich",
            "Kuznecovich", "Molkovich"};
        int[] workshop = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2};//Массив номеров Цехов
        int[] experience = {1, 2, 1, 4, 2, 2, 2, 3, 3, 3};//Массив опыта стажа работников
        //Цикл для вывода в лист работников
        for (int i = 0; i < 10; i++) {
            Worker human = new Worker(names[i], surnames[i],
                    patronymic[i], workshop[i], experience[i]);
            array[i] = human;
            list1.addElement((i + 1) + ". " + human.getName() + " " + human.getSurname() + " "
                    + human.getPatronymic() + " Цех: " + human.getWorkshop()
                    + " Опыт работы: " + human.getExperience() + " лет.");
//            if (human.getWorkshop()== 1) {
//                total += human.getExperience();
//                count++;
        }
        int total = 0;//Переменная для общего опыта работников в 1 цехе
        int count = 0;//Переменная для счета количества работников в 1 цехе
        //Цикл для вывода ср.стажа работников 1 цеха
        for (int i = 0; i < 10; i++) {
            if (array[i].getWorkshop() == 1) {
                total += array[i].getExperience();
                count++;
            }
        }
        //Вывод работников в лист, возможность ввести путь для файла и его создания 
        listTask32P4OutArray.setModel(list1);
        if (rbtnSaveAnswer.isSelected()) {
            if (txtfWayToSaveTheFile.getText().isEmpty() || txtfSaveFileName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Поле пусто, введите значения!");
            } else {
                String text = "Средний стаж работников 1-го цеха: " + total / count + "";
                fileName = txtfWayToSaveTheFile.getText() + txtfSaveFileName.getText()+".txt";
                Files.save(fileName, text);
                lblTask32P4OutAnswer.setText(total / count + "");
                lblOutFileSaved.setText("Файл сохранён "+"("+fileName+")");
            }

        }
        

    }

    public Tasks1() {
        initComponents();
        txtfWayToSaveTheFile.setVisible(false);
        txtfSaveFileName.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbPanePart1 = new javax.swing.JTabbedPane();
        panel1 = new javax.swing.JPanel();
        tpaneTask7P1 = new javax.swing.JTabbedPane();
        panelTask7P1 = new javax.swing.JPanel();
        lblTask7P1 = new javax.swing.JLabel();
        lblList7P1 = new javax.swing.JLabel();
        lblOutList7P1 = new javax.swing.JLabel();
        btnStartT7P1 = new javax.swing.JButton();
        lblSrArifmetichPos7 = new javax.swing.JLabel();
        lblOutSrArif7 = new javax.swing.JLabel();
        lblSrArifmetichDis7 = new javax.swing.JLabel();
        lblOutSrArifmDis7 = new javax.swing.JLabel();
        lblNulls7 = new javax.swing.JLabel();
        lblCountNulls7 = new javax.swing.JLabel();
        panelTask32P1 = new javax.swing.JPanel();
        lblTask32P1 = new javax.swing.JLabel();
        lblArray32P1 = new javax.swing.JLabel();
        lblOutArray32P1 = new javax.swing.JLabel();
        btnStartT32P1 = new javax.swing.JButton();
        lblMaxDis32P1 = new javax.swing.JLabel();
        lblOutMaxDis32P1 = new javax.swing.JLabel();
        panelTask57P1 = new javax.swing.JPanel();
        lblTask57P1 = new javax.swing.JLabel();
        btnStart57P1 = new javax.swing.JButton();
        lblArray57P1 = new javax.swing.JLabel();
        lblOutArray57P1 = new javax.swing.JLabel();
        lblACommonSumm57P1 = new javax.swing.JLabel();
        lblOutSumm57P1 = new javax.swing.JLabel();
        lblNumElem57P1 = new javax.swing.JLabel();
        lblOutNumElem57P1 = new javax.swing.JLabel();
        lblPosWork57P1 = new javax.swing.JLabel();
        lblOutCountWork57P1 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        tbPanePart2 = new javax.swing.JTabbedPane();
        panelT7P2 = new javax.swing.JPanel();
        lblTask7P2 = new javax.swing.JLabel();
        btnStartTask7P2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListT7P2 = new javax.swing.JTable();
        txtfInputRowT7P2 = new javax.swing.JTextField();
        txtfInputColT7P2 = new javax.swing.JTextField();
        lblTextRowsT7P2 = new javax.swing.JLabel();
        lblTextColumnT7P2 = new javax.swing.JLabel();
        lblTaskText7P2p1 = new javax.swing.JLabel();
        lblTaskText7P2p2 = new javax.swing.JLabel();
        lblOutAnswerT7P2p1 = new javax.swing.JLabel();
        lblOutAnswerT7P2p2 = new javax.swing.JLabel();
        panelTestTable = new javax.swing.JPanel();
        scrpTest = new javax.swing.JScrollPane();
        tblTest = new javax.swing.JTable();
        btnStartTest = new javax.swing.JButton();
        panelT32P2 = new javax.swing.JPanel();
        lblTaskText32P2 = new javax.swing.JLabel();
        btnStartT32P2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListT32P2 = new javax.swing.JTable();
        lblRowTextT32P2 = new javax.swing.JLabel();
        lblColTextT32P2 = new javax.swing.JLabel();
        txtfInputRT32P2 = new javax.swing.JTextField();
        txtfInputCT32P2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOutMinT32P2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOutMaxT32P2 = new javax.swing.JTable();
        panel3 = new javax.swing.JPanel();
        tbPanePart3 = new javax.swing.JTabbedPane();
        panelT7P3 = new javax.swing.JPanel();
        lblTask7P3Text = new javax.swing.JLabel();
        txtfInputStringTask7P3 = new javax.swing.JTextField();
        btnStartOfTask7P3 = new javax.swing.JButton();
        lblTextOutAnswerT7P3 = new javax.swing.JLabel();
        scrlpT7P3 = new javax.swing.JScrollPane();
        listOutTask7P3 = new javax.swing.JList<>();
        panelT32P3 = new javax.swing.JPanel();
        lblTask32P3Text = new javax.swing.JLabel();
        btnTask32P3Start = new javax.swing.JButton();
        txtfTask32P3Input = new javax.swing.JTextField();
        lblOutAnswerTextT32P3 = new javax.swing.JLabel();
        lblOutAnswerT32P3 = new javax.swing.JLabel();
        panelT57P3 = new javax.swing.JPanel();
        lblTask57P3Text = new javax.swing.JLabel();
        txtfInputTextT57P3 = new javax.swing.JTextField();
        btnTask57P3Start = new javax.swing.JButton();
        lblOutputTextT57P3 = new javax.swing.JLabel();
        lblOutputAnswerT57P3 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        tbPanePart4 = new javax.swing.JTabbedPane();
        panelT32P4 = new javax.swing.JPanel();
        lblTask32P4Text = new javax.swing.JLabel();
        btnT32P4Start = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        listTask32P4OutArray = new javax.swing.JList<>();
        lblTask32P4TextAnswer = new javax.swing.JLabel();
        lblTask32P4OutAnswer = new javax.swing.JLabel();
        txtfWayToSaveTheFile = new javax.swing.JTextField();
        rbtnSaveAnswer = new javax.swing.JRadioButton();
        txtfSaveFileName = new javax.swing.JTextField();
        lblOutFileSaved = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mbarFile = new javax.swing.JMenu();
        mbarItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTask7P1.setText("<html>В заданном массиве найти среднее арифметическое положительных чисел, среднее арифметическое <p> отрицательных чисел и число нулей.</html>");
        lblTask7P1.setToolTipText("");
        lblTask7P1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lblList7P1.setText("Исходный массив:");

        lblOutList7P1.setText("0");

        btnStartT7P1.setText("Start");
        btnStartT7P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartT7P1ActionPerformed(evt);
            }
        });

        lblSrArifmetichPos7.setText("Ср. арифметическое полож. чисел:");

        lblOutSrArif7.setText("0");

        lblSrArifmetichDis7.setText("Ср. арифметическое отриц. чисел:");

        lblOutSrArifmDis7.setText("0");

        lblNulls7.setText("Количество нулей:");

        lblCountNulls7.setText("0");

        javax.swing.GroupLayout panelTask7P1Layout = new javax.swing.GroupLayout(panelTask7P1);
        panelTask7P1.setLayout(panelTask7P1Layout);
        panelTask7P1Layout.setHorizontalGroup(
            panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTask7P1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTask7P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTask7P1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTask7P1Layout.createSequentialGroup()
                                .addComponent(lblList7P1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblOutList7P1))
                            .addGroup(panelTask7P1Layout.createSequentialGroup()
                                .addGroup(panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSrArifmetichPos7)
                                    .addComponent(lblSrArifmetichDis7)
                                    .addGroup(panelTask7P1Layout.createSequentialGroup()
                                        .addComponent(lblNulls7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCountNulls7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOutSrArifmDis7)
                                    .addComponent(lblOutSrArif7)))))
                    .addComponent(btnStartT7P1))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        panelTask7P1Layout.setVerticalGroup(
            panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTask7P1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTask7P1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblList7P1)
                    .addComponent(lblOutList7P1))
                .addGap(18, 18, 18)
                .addGroup(panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSrArifmetichPos7)
                    .addComponent(lblOutSrArif7))
                .addGap(18, 18, 18)
                .addGroup(panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSrArifmetichDis7)
                    .addComponent(lblOutSrArifmDis7))
                .addGap(18, 18, 18)
                .addGroup(panelTask7P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNulls7)
                    .addComponent(lblCountNulls7))
                .addGap(33, 33, 33)
                .addComponent(btnStartT7P1)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        tpaneTask7P1.addTab("Задача 7", panelTask7P1);

        lblTask32P1.setText("Задан одномерный массив А[1..20]. Найти максимальный элемент среди отрицательных элементов.");

        lblArray32P1.setText("Исходный массив:");

        lblOutArray32P1.setText("0");

        btnStartT32P1.setText("Start");
        btnStartT32P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartT32P1ActionPerformed(evt);
            }
        });

        lblMaxDis32P1.setText("Максимальное число среди отрицательных:");

        lblOutMaxDis32P1.setText("0");

        javax.swing.GroupLayout panelTask32P1Layout = new javax.swing.GroupLayout(panelTask32P1);
        panelTask32P1.setLayout(panelTask32P1Layout);
        panelTask32P1Layout.setHorizontalGroup(
            panelTask32P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTask32P1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTask32P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTask32P1)
                    .addGroup(panelTask32P1Layout.createSequentialGroup()
                        .addComponent(lblArray32P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOutArray32P1))
                    .addComponent(btnStartT32P1)
                    .addGroup(panelTask32P1Layout.createSequentialGroup()
                        .addComponent(lblMaxDis32P1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOutMaxDis32P1)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        panelTask32P1Layout.setVerticalGroup(
            panelTask32P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTask32P1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTask32P1)
                .addGap(30, 30, 30)
                .addGroup(panelTask32P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArray32P1)
                    .addComponent(lblOutArray32P1))
                .addGap(18, 18, 18)
                .addGroup(panelTask32P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaxDis32P1)
                    .addComponent(lblOutMaxDis32P1))
                .addGap(50, 50, 50)
                .addComponent(btnStartT32P1)
                .addContainerGap(321, Short.MAX_VALUE))
        );

        tpaneTask7P1.addTab("Задача 32", panelTask32P1);

        lblTask57P1.setText("<html>В одномерном массиве хранятся сведения о стоимости товаров, проданных фирмой за каждый месяц года. <p>Определить: а) общую сумму продаж за год; б) номера месяцев, когда сумма продаж превысила среднюю за год; <p>в) в каком полугодии работа фирмы была более эффективна.</html>");

        btnStart57P1.setText("Start");
        btnStart57P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart57P1ActionPerformed(evt);
            }
        });

        lblArray57P1.setText("Исходный массив:");

        lblOutArray57P1.setText("0");

        lblACommonSumm57P1.setText("а) Общая сумма продаж за год:");

        lblOutSumm57P1.setText("0");

        lblNumElem57P1.setText("б) Номера месяцев, когда сумма продаж превысила среднюю за год:");

        lblOutNumElem57P1.setText("0");

        lblPosWork57P1.setText("в) Полугодие, в котром работа фирмы была более эффективна:");

        lblOutCountWork57P1.setText("0");

        javax.swing.GroupLayout panelTask57P1Layout = new javax.swing.GroupLayout(panelTask57P1);
        panelTask57P1.setLayout(panelTask57P1Layout);
        panelTask57P1Layout.setHorizontalGroup(
            panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTask57P1Layout.createSequentialGroup()
                .addGroup(panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTask57P1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTask57P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStart57P1)))
                    .addGroup(panelTask57P1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTask57P1Layout.createSequentialGroup()
                                .addComponent(lblACommonSumm57P1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblOutSumm57P1))
                            .addGroup(panelTask57P1Layout.createSequentialGroup()
                                .addComponent(lblArray57P1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblOutArray57P1))
                            .addGroup(panelTask57P1Layout.createSequentialGroup()
                                .addComponent(lblNumElem57P1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblOutNumElem57P1))
                            .addGroup(panelTask57P1Layout.createSequentialGroup()
                                .addComponent(lblPosWork57P1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblOutCountWork57P1)))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        panelTask57P1Layout.setVerticalGroup(
            panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTask57P1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTask57P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArray57P1)
                    .addComponent(lblOutArray57P1))
                .addGap(18, 18, 18)
                .addGroup(panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblACommonSumm57P1)
                    .addComponent(lblOutSumm57P1))
                .addGap(18, 18, 18)
                .addGroup(panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumElem57P1)
                    .addComponent(lblOutNumElem57P1))
                .addGap(18, 18, 18)
                .addGroup(panelTask57P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosWork57P1)
                    .addComponent(lblOutCountWork57P1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addComponent(btnStart57P1)
                .addGap(30, 30, 30))
        );

        tpaneTask7P1.addTab("Задача 57", panelTask57P1);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(tpaneTask7P1)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpaneTask7P1)
                .addGap(35, 35, 35))
        );

        tbPanePart1.addTab("Раздел 1", panel1);

        lblTask7P2.setText("<html>Составить программу нахождения максимального элемента в каждом столбце<p> и минимального в каждой строке квадратной матрицы[4x4].</html>");

        btnStartTask7P2.setText("Start");
        btnStartTask7P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTask7P2ActionPerformed(evt);
            }
        });

        tblListT7P2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Столбец 1", "Столбец 2", "Столбец 3", "Столбец 4"
            }
        ));
        jScrollPane1.setViewportView(tblListT7P2);

        txtfInputRowT7P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfInputRowT7P2ActionPerformed(evt);
            }
        });

        lblTextRowsT7P2.setText("Row");

        lblTextColumnT7P2.setText("Col");

        lblTaskText7P2p1.setText("Максимальные числа в столбцах:");

        lblTaskText7P2p2.setText("Минимальные числа в строках:");

        lblOutAnswerT7P2p1.setText("0");

        lblOutAnswerT7P2p2.setText("0");

        javax.swing.GroupLayout panelT7P2Layout = new javax.swing.GroupLayout(panelT7P2);
        panelT7P2.setLayout(panelT7P2Layout);
        panelT7P2Layout.setHorizontalGroup(
            panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelT7P2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelT7P2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelT7P2Layout.createSequentialGroup()
                                .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTextRowsT7P2)
                                    .addComponent(lblTextColumnT7P2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfInputColT7P2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfInputRowT7P2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addGroup(panelT7P2Layout.createSequentialGroup()
                                .addComponent(lblTaskText7P2p1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblOutAnswerT7P2p1))
                            .addGroup(panelT7P2Layout.createSequentialGroup()
                                .addComponent(lblTaskText7P2p2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblOutAnswerT7P2p2))))
                    .addComponent(lblTask7P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStartTask7P2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelT7P2Layout.setVerticalGroup(
            panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelT7P2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTask7P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelT7P2Layout.createSequentialGroup()
                        .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfInputRowT7P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextRowsT7P2))
                        .addGap(18, 18, 18)
                        .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfInputColT7P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextColumnT7P2))
                        .addGap(46, 46, 46)
                        .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTaskText7P2p1)
                            .addComponent(lblOutAnswerT7P2p1))
                        .addGap(9, 9, 9)
                        .addGroup(panelT7P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTaskText7P2p2)
                            .addComponent(lblOutAnswerT7P2p2))))
                .addGap(18, 18, 18)
                .addComponent(btnStartTask7P2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbPanePart2.addTab("Задание 7", panelT7P2);

        tblTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null},
                {"2", null, null, null, null, null},
                {"3", null, null, null, null, null},
                {"4", null, null, null, null, null},
                {"5", null, null, null, null, null},
                {"6", null, null, null, null, null}
            },
            new String [] {
                "Строка 1", "Строка 2", "Строка 3", "Строка 4", "Строка 5", "Строка 6"
            }
        ));
        scrpTest.setViewportView(tblTest);

        btnStartTest.setText("Start");
        btnStartTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTestTableLayout = new javax.swing.GroupLayout(panelTestTable);
        panelTestTable.setLayout(panelTestTableLayout);
        panelTestTableLayout.setHorizontalGroup(
            panelTestTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTestTableLayout.createSequentialGroup()
                .addComponent(scrpTest, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnStartTest)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTestTableLayout.setVerticalGroup(
            panelTestTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTestTableLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnStartTest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelTestTableLayout.createSequentialGroup()
                .addComponent(scrpTest, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tbPanePart2.addTab("Тест", panelTestTable);

        lblTaskText32P2.setText("<html>Вывести на экран матрицу 5х4, элементами которой являются целые случайные числа из интервала [30,70].<p>Определить номер минимального элемента в каждом четном столбце и номер максимального элемента в каждом нечетном<p> столбце.</html>");

        btnStartT32P2.setText("Start");
        btnStartT32P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartT32P2ActionPerformed(evt);
            }
        });

        tblListT32P2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Столбец 1", "Столбец 2", "Столбец 3", "Столбец 4", "Столбец 5"
            }
        ));
        jScrollPane2.setViewportView(tblListT32P2);

        lblRowTextT32P2.setText("Row");

        lblColTextT32P2.setText("Col");

        tblOutMinT32P2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Min", "2"
            }
        ));
        jScrollPane3.setViewportView(tblOutMinT32P2);

        tblOutMaxT32P2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Max", "2"
            }
        ));
        jScrollPane4.setViewportView(tblOutMaxT32P2);

        javax.swing.GroupLayout panelT32P2Layout = new javax.swing.GroupLayout(panelT32P2);
        panelT32P2.setLayout(panelT32P2Layout);
        panelT32P2Layout.setHorizontalGroup(
            panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelT32P2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelT32P2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRowTextT32P2)
                            .addComponent(lblColTextT32P2))
                        .addGap(18, 18, 18)
                        .addGroup(panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfInputRT32P2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfInputCT32P2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelT32P2Layout.createSequentialGroup()
                        .addGroup(panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelT32P2Layout.createSequentialGroup()
                                .addComponent(lblTaskText32P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 59, Short.MAX_VALUE))
                            .addGroup(panelT32P2Layout.createSequentialGroup()
                                .addComponent(btnStartT32P2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelT32P2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelT32P2Layout.setVerticalGroup(
            panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelT32P2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTaskText32P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelT32P2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelT32P2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfInputRT32P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRowTextT32P2))
                        .addGap(10, 10, 10)
                        .addGroup(panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfInputCT32P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColTextT32P2))))
                .addGroup(panelT32P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelT32P2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStartT32P2)
                        .addGap(138, 138, 138))
                    .addGroup(panelT32P2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(91, Short.MAX_VALUE))))
        );

        tbPanePart2.addTab("Задание 32", panelT32P2);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbPanePart2)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPanePart2)
                .addContainerGap())
        );

        tbPanePart1.addTab("Раздел 2", panel2);

        lblTask7P3Text.setText("Разделить заданный текст на строки. В качестве разделителя в тексте используется символ @.");

        txtfInputStringTask7P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfInputStringTask7P3ActionPerformed(evt);
            }
        });

        btnStartOfTask7P3.setText("Start");
        btnStartOfTask7P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartOfTask7P3ActionPerformed(evt);
            }
        });

        lblTextOutAnswerT7P3.setText("Итог:");

        scrlpT7P3.setViewportView(listOutTask7P3);

        javax.swing.GroupLayout panelT7P3Layout = new javax.swing.GroupLayout(panelT7P3);
        panelT7P3.setLayout(panelT7P3Layout);
        panelT7P3Layout.setHorizontalGroup(
            panelT7P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelT7P3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnStartOfTask7P3)
                .addGap(37, 37, 37))
            .addGroup(panelT7P3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelT7P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTask7P3Text)
                    .addGroup(panelT7P3Layout.createSequentialGroup()
                        .addComponent(lblTextOutAnswerT7P3)
                        .addGap(30, 30, 30)
                        .addComponent(scrlpT7P3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtfInputStringTask7P3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        panelT7P3Layout.setVerticalGroup(
            panelT7P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelT7P3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTask7P3Text)
                .addGap(18, 18, 18)
                .addComponent(txtfInputStringTask7P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(panelT7P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTextOutAnswerT7P3)
                    .addComponent(scrlpT7P3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(btnStartOfTask7P3)
                .addGap(115, 115, 115))
        );

        tbPanePart3.addTab("Задача 7", panelT7P3);

        lblTask32P3Text.setText("Преобразовать введенную строку цифр, поставив перед каждой цифрой \"5\" цифру \"6\".");

        btnTask32P3Start.setText("Start");
        btnTask32P3Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTask32P3StartActionPerformed(evt);
            }
        });

        txtfTask32P3Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfTask32P3InputActionPerformed(evt);
            }
        });

        lblOutAnswerTextT32P3.setText("Итог:");

        javax.swing.GroupLayout panelT32P3Layout = new javax.swing.GroupLayout(panelT32P3);
        panelT32P3.setLayout(panelT32P3Layout);
        panelT32P3Layout.setHorizontalGroup(
            panelT32P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelT32P3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTask32P3Start)
                .addGap(42, 42, 42))
            .addGroup(panelT32P3Layout.createSequentialGroup()
                .addGroup(panelT32P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelT32P3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblTask32P3Text, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelT32P3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtfTask32P3Input, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelT32P3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblOutAnswerTextT32P3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOutAnswerT32P3)))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        panelT32P3Layout.setVerticalGroup(
            panelT32P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelT32P3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTask32P3Text)
                .addGap(28, 28, 28)
                .addComponent(txtfTask32P3Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(panelT32P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutAnswerTextT32P3)
                    .addComponent(lblOutAnswerT32P3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(btnTask32P3Start)
                .addGap(83, 83, 83))
        );

        tbPanePart3.addTab("Задача 32", panelT32P3);

        lblTask57P3Text.setText("Создать функцию пользователя, определяющую количество символов введенной строки, ASCII-коды которых >=70.");

        btnTask57P3Start.setText("Start");
        btnTask57P3Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTask57P3StartActionPerformed(evt);
            }
        });

        lblOutputTextT57P3.setText("Количество символов введенной строки, ASCII-коды которых >=70: ");

        lblOutputAnswerT57P3.setText("0");

        javax.swing.GroupLayout panelT57P3Layout = new javax.swing.GroupLayout(panelT57P3);
        panelT57P3.setLayout(panelT57P3Layout);
        panelT57P3Layout.setHorizontalGroup(
            panelT57P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelT57P3Layout.createSequentialGroup()
                .addGroup(panelT57P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelT57P3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTask57P3Text))
                    .addGroup(panelT57P3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelT57P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfInputTextT57P3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelT57P3Layout.createSequentialGroup()
                                .addComponent(lblOutputTextT57P3)
                                .addGap(18, 18, 18)
                                .addComponent(lblOutputAnswerT57P3)))))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelT57P3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTask57P3Start)
                .addGap(59, 59, 59))
        );
        panelT57P3Layout.setVerticalGroup(
            panelT57P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelT57P3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTask57P3Text)
                .addGap(18, 18, 18)
                .addComponent(txtfInputTextT57P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(panelT57P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutputTextT57P3)
                    .addComponent(lblOutputAnswerT57P3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(btnTask57P3Start)
                .addGap(50, 50, 50))
        );

        tbPanePart3.addTab("Задача 57", panelT57P3);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbPanePart3)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPanePart3)
                .addContainerGap())
        );

        tbPanePart1.addTab("Раздел 3", panel3);

        lblTask32P4Text.setText("<html>Создать файл, содержащий данные: ФИО работника; цех; стаж работы. Просмотреть записи.<p> Определить средний стаж работы работников 1 - го цеха.</html>");

        btnT32P4Start.setText("Start");
        btnT32P4Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT32P4StartActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(listTask32P4OutArray);

        lblTask32P4TextAnswer.setText("Средний стаж работы 1-го цеха:");

        txtfWayToSaveTheFile.setText("D:\\");
            txtfWayToSaveTheFile.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtfWayToSaveTheFileActionPerformed(evt);
                }
            });

            rbtnSaveAnswer.setText("Сохранить ответ в файл");
            rbtnSaveAnswer.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rbtnSaveAnswerActionPerformed(evt);
                }
            });

            txtfSaveFileName.setText("Имя файла");

            javax.swing.GroupLayout panelT32P4Layout = new javax.swing.GroupLayout(panelT32P4);
            panelT32P4.setLayout(panelT32P4Layout);
            panelT32P4Layout.setHorizontalGroup(
                panelT32P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelT32P4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnT32P4Start)
                    .addGap(17, 17, 17))
                .addGroup(panelT32P4Layout.createSequentialGroup()
                    .addGroup(panelT32P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelT32P4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblTask32P4Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelT32P4Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(panelT32P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbtnSaveAnswer)
                                .addGroup(panelT32P4Layout.createSequentialGroup()
                                    .addComponent(txtfWayToSaveTheFile, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtfSaveFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblOutFileSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelT32P4Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(lblTask32P4TextAnswer)
                            .addGap(18, 18, 18)
                            .addComponent(lblTask32P4OutAnswer)))
                    .addContainerGap(250, Short.MAX_VALUE))
            );
            panelT32P4Layout.setVerticalGroup(
                panelT32P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelT32P4Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(lblTask32P4Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addGroup(panelT32P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTask32P4TextAnswer)
                        .addComponent(lblTask32P4OutAnswer))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rbtnSaveAnswer)
                    .addGroup(panelT32P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelT32P4Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnT32P4Start))
                        .addGroup(panelT32P4Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelT32P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfWayToSaveTheFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfSaveFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblOutFileSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
            );

            tbPanePart4.addTab("Задача 32", panelT32P4);

            javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tbPanePart4)
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tbPanePart4))
            );

            tbPanePart1.addTab("Раздел 4", panel4);

            mbarFile.setText("File");

            mbarItem1.setText("О программе");
            mbarItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mbarItem1ActionPerformed(evt);
                }
            });
            mbarFile.add(mbarItem1);

            menuBar.add(mbarFile);

            setJMenuBar(menuBar);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tbPanePart1)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tbPanePart1)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnStartT7P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartT7P1ActionPerformed
        Task7P1();
    }//GEN-LAST:event_btnStartT7P1ActionPerformed

    private void btnStartT32P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartT32P1ActionPerformed
        Task32P1();
    }//GEN-LAST:event_btnStartT32P1ActionPerformed

    private void btnStart57P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart57P1ActionPerformed
        lblOutNumElem57P1.setText("");
        Task57P1();
    }//GEN-LAST:event_btnStart57P1ActionPerformed

    private void btnStartTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTestActionPerformed

    }//GEN-LAST:event_btnStartTestActionPerformed

    private void btnStartTask7P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTask7P2ActionPerformed
        tm.setRowCount(0);
        Task7P2();
    }//GEN-LAST:event_btnStartTask7P2ActionPerformed

    private void btnStartT32P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartT32P2ActionPerformed
        tm.setRowCount(0);
        tm1.setRowCount(0);
        tm2.setRowCount(0);
        Task32P2();
    }//GEN-LAST:event_btnStartT32P2ActionPerformed

    private void txtfInputRowT7P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfInputRowT7P2ActionPerformed

    }//GEN-LAST:event_txtfInputRowT7P2ActionPerformed

    private void mbarItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbarItem1ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Выполнил Калистратов Артём Дмитриевич 21-ИС-1");
    }//GEN-LAST:event_mbarItem1ActionPerformed

    private void txtfInputStringTask7P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfInputStringTask7P3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfInputStringTask7P3ActionPerformed

    private void btnStartOfTask7P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartOfTask7P3ActionPerformed
        Task7P3();
    }//GEN-LAST:event_btnStartOfTask7P3ActionPerformed

    private void btnTask32P3StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTask32P3StartActionPerformed
        Task32P3();
    }//GEN-LAST:event_btnTask32P3StartActionPerformed

    private void txtfTask32P3InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfTask32P3InputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfTask32P3InputActionPerformed

    private void btnTask57P3StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTask57P3StartActionPerformed
        Task57P3();
    }//GEN-LAST:event_btnTask57P3StartActionPerformed

    private void btnT32P4StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT32P4StartActionPerformed
        Task32P4();
    }//GEN-LAST:event_btnT32P4StartActionPerformed

    private void rbtnSaveAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSaveAnswerActionPerformed
        if (rbtnSaveAnswer.isSelected()) {//Если включена кнопка, то выполняется
            txtfWayToSaveTheFile.setVisible(true);
            txtfSaveFileName.setVisible(true);
            System.out.println("true");
            lblOutFileSaved.setText("↑");
        } else {
            txtfWayToSaveTheFile.setVisible(false);
            txtfSaveFileName.setVisible(false);
        }
    }//GEN-LAST:event_rbtnSaveAnswerActionPerformed

    private void txtfWayToSaveTheFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfWayToSaveTheFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfWayToSaveTheFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tasks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tasks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tasks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tasks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tasks1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart57P1;
    private javax.swing.JButton btnStartOfTask7P3;
    private javax.swing.JButton btnStartT32P1;
    private javax.swing.JButton btnStartT32P2;
    private javax.swing.JButton btnStartT7P1;
    private javax.swing.JButton btnStartTask7P2;
    private javax.swing.JButton btnStartTest;
    private javax.swing.JButton btnT32P4Start;
    private javax.swing.JButton btnTask32P3Start;
    private javax.swing.JButton btnTask57P3Start;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblACommonSumm57P1;
    private javax.swing.JLabel lblArray32P1;
    private javax.swing.JLabel lblArray57P1;
    private javax.swing.JLabel lblColTextT32P2;
    private javax.swing.JLabel lblCountNulls7;
    private javax.swing.JLabel lblList7P1;
    private javax.swing.JLabel lblMaxDis32P1;
    private javax.swing.JLabel lblNulls7;
    private javax.swing.JLabel lblNumElem57P1;
    private javax.swing.JLabel lblOutAnswerT32P3;
    private javax.swing.JLabel lblOutAnswerT7P2p1;
    private javax.swing.JLabel lblOutAnswerT7P2p2;
    private javax.swing.JLabel lblOutAnswerTextT32P3;
    private javax.swing.JLabel lblOutArray32P1;
    private javax.swing.JLabel lblOutArray57P1;
    private javax.swing.JLabel lblOutCountWork57P1;
    private javax.swing.JLabel lblOutFileSaved;
    private javax.swing.JLabel lblOutList7P1;
    private javax.swing.JLabel lblOutMaxDis32P1;
    private javax.swing.JLabel lblOutNumElem57P1;
    private javax.swing.JLabel lblOutSrArif7;
    private javax.swing.JLabel lblOutSrArifmDis7;
    private javax.swing.JLabel lblOutSumm57P1;
    private javax.swing.JLabel lblOutputAnswerT57P3;
    private javax.swing.JLabel lblOutputTextT57P3;
    private javax.swing.JLabel lblPosWork57P1;
    private javax.swing.JLabel lblRowTextT32P2;
    private javax.swing.JLabel lblSrArifmetichDis7;
    private javax.swing.JLabel lblSrArifmetichPos7;
    private javax.swing.JLabel lblTask32P1;
    private javax.swing.JLabel lblTask32P3Text;
    private javax.swing.JLabel lblTask32P4OutAnswer;
    private javax.swing.JLabel lblTask32P4Text;
    private javax.swing.JLabel lblTask32P4TextAnswer;
    private javax.swing.JLabel lblTask57P1;
    private javax.swing.JLabel lblTask57P3Text;
    private javax.swing.JLabel lblTask7P1;
    private javax.swing.JLabel lblTask7P2;
    private javax.swing.JLabel lblTask7P3Text;
    private javax.swing.JLabel lblTaskText32P2;
    private javax.swing.JLabel lblTaskText7P2p1;
    private javax.swing.JLabel lblTaskText7P2p2;
    private javax.swing.JLabel lblTextColumnT7P2;
    private javax.swing.JLabel lblTextOutAnswerT7P3;
    private javax.swing.JLabel lblTextRowsT7P2;
    private javax.swing.JList<String> listOutTask7P3;
    private javax.swing.JList<String> listTask32P4OutArray;
    private javax.swing.JMenu mbarFile;
    private javax.swing.JMenuItem mbarItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panelT32P2;
    private javax.swing.JPanel panelT32P3;
    private javax.swing.JPanel panelT32P4;
    private javax.swing.JPanel panelT57P3;
    private javax.swing.JPanel panelT7P2;
    private javax.swing.JPanel panelT7P3;
    private javax.swing.JPanel panelTask32P1;
    private javax.swing.JPanel panelTask57P1;
    private javax.swing.JPanel panelTask7P1;
    private javax.swing.JPanel panelTestTable;
    private javax.swing.JRadioButton rbtnSaveAnswer;
    private javax.swing.JScrollPane scrlpT7P3;
    private javax.swing.JScrollPane scrpTest;
    private javax.swing.JTabbedPane tbPanePart1;
    private javax.swing.JTabbedPane tbPanePart2;
    private javax.swing.JTabbedPane tbPanePart3;
    private javax.swing.JTabbedPane tbPanePart4;
    private javax.swing.JTable tblListT32P2;
    private javax.swing.JTable tblListT7P2;
    private javax.swing.JTable tblOutMaxT32P2;
    private javax.swing.JTable tblOutMinT32P2;
    private javax.swing.JTable tblTest;
    private javax.swing.JTabbedPane tpaneTask7P1;
    private javax.swing.JTextField txtfInputCT32P2;
    private javax.swing.JTextField txtfInputColT7P2;
    private javax.swing.JTextField txtfInputRT32P2;
    private javax.swing.JTextField txtfInputRowT7P2;
    private javax.swing.JTextField txtfInputStringTask7P3;
    private javax.swing.JTextField txtfInputTextT57P3;
    private javax.swing.JTextField txtfSaveFileName;
    private javax.swing.JTextField txtfTask32P3Input;
    private javax.swing.JTextField txtfWayToSaveTheFile;
    // End of variables declaration//GEN-END:variables
}
