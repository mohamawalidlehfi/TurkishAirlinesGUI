import javax.swing.;
import java.awt.;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class TurkishAirlinesGUI {
    private JPanel mainPanel, panel_2, odemePanel, panelList, panel2;
    private JTextField textFieldNereden, textFieldNereye, textFieldTarih, textFieldSayiYolcular;
    private ButtonGroup radioButtonGroup;
    private JTabbedPane tabbedPane;

    public TurkishAirlinesGUI() {
        createMainPanel();
        createPaymentPanel();
        createCheckInPanel();
        createTabbedPane();
        createAndShowGUI();
    }

    private void createMainPanel() {
        mainPanel = new JPanel(null);
        mainPanel.setBorder(BorderFactory.createTitledBorder(Uçak bileti));
        mainPanel.setBounds(200, 170, 800, 200);
        
        JRadioButton r1 = new JRadioButton(Gidiş-Dönüş);
        JRadioButton r2 = new JRadioButton(Tek yön);
        JRadioButton r3 = new JRadioButton(İstanbulda Stopover);
        JRadioButton r4 = new JRadioButton(Çoklu uçuş);
        
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(r1);
        radioButtonGroup.add(r2);
        radioButtonGroup.add(r3);
        radioButtonGroup.add(r4);
        
        JLabel Nereden = new JLabel(Nereden);
        JLabel Nereye = new JLabel(Nereye);
        JLabel Gidiş = new JLabel(Gidiş Tarih);
        JLabel Dönüş = new JLabel(Dönüş Tarih);

        String[] items = {
            Atatürk International Airport, Turkey, Istanbul, IST,
            Sabih Gökçen International Airport, Turkey, Istanbul, SAW,
            Ankara Esenboğa Airport, Turkey, Ankara, ESB,
            Antalya Airport, Turkey, Antalya, AYT,
            Izmir Adnan Menderes Airport, Turkey, Izmir, ADB,
            Dalaman Airport, Turkey, Muğla, DLM,
            Bodrum Milas Airport, Turkey, Muğla, BJV,
            Trabzon Airport, Turkey, Trabzon, TZX,
            Diyarbakır Airport, Turkey, Diyarbakır, DIY,
            Gaziantep Airport, Turkey, Gaziantep, GZT,
            Van Ferit Melen Airport, Turkey, Van, VAN,
            Adana Şakirpaşa Airport, Turkey, Adana, ADA,
            Konya Airport, Turkey, Konya, KYA,
            Ercan International Airport, Cyprus, Nicosia, ECN,
            Erzurum Airport, Turkey, Erzurum, ERZ,
            Samsun Çarşamba Airport, Turkey, Samsun, SZF,
            Nevşehir Kapadokya Airport, Turkey, Nevşehir, NAV,
            Kayseri Erkilet Airport, Turkey, Kayseri, ASR,
            Malatya Erhaç Airport, Turkey, Malatya, MLX,
            Mardin Airport, Turkey, Mardin, MQM,
            Şanlıurfa GAP Airport, Turkey, Şanlıurfa, GNY,
            Hatay Airport, Turkey, Hatay, HTY,
            Elazığ Airport, Turkey, Elazığ, EZS,
            Batman Airport, Turkey, Batman, BAL,
            Muğla Milas-Bodrum Airport, Turkey, Muğla, BJV,
            Isparta Süleyman Demirel Airport, Turkey, Isparta, ISE,
            Kars Harakani Airport, Turkey, Kars, KSY
        };

        JComboBox NeredenComboBox = new JComboBox(items);
        JComboBox NereyecomboBox = new JComboBox(items);
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField Fiyatfield = new JTextField();
        JButton button = new JButton(Devam);
        button.setBackground(Color.RED);
        button.setFont(new Font(Arial, Font.BOLD, 24));
        r1.setBounds(10, 20, 100, 25);
        r2.setBounds(110, 20, 80, 25);
        r3.setBounds(190, 20, 150, 25);
        r4.setBounds(350, 20, 100, 25);
        Nereden.setBounds(15, 60, 100, 25);
        NeredenComboBox.setBounds(90, 60, 330, 25);
        Nereye.setBounds(15, 110, 100, 25);
        NereyecomboBox.setBounds(90, 110, 330, 25);
        Gidiş.setBounds(430, 110, 100, 25);
        field3.setBounds(505, 110, 130, 25);
        Dönüş.setBounds(430, 60, 100, 25);
        field4.setBounds(505, 60, 130, 25);
        button.setBounds(640, 60, 140, 75);

        mainPanel.add(Nereden);
        mainPanel.add(Nereye);
        mainPanel.add(Gidiş);
        mainPanel.add(Dönüş);
        mainPanel.add(Fiyatfield);
        mainPanel.add(NeredenComboBox);
        mainPanel.add(NereyecomboBox);
        mainPanel.add(field3);
        mainPanel.add(field4);
        mainPanel.add(button);
        mainPanel.add(r1);
        mainPanel.add(r2);
        mainPanel.add(r3);
        mainPanel.add(r4);
        
        
       
    }
    

    private void createPaymentPanel() {
        odemePanel = new JPanel(null);
        odemePanel.setBorder(BorderFactory.createTitledBorder(Müşteri bilgileri));
        odemePanel.setBounds(200, 170, 800, 200);

        JLabel FirstName = new JLabel(First Name);
        JLabel LastName = new JLabel(Last Name);
        JLabel Email = new JLabel(Email);
        JLabel Phone = new JLabel(Phone);
        JLabel Gender = new JLabel(Gender);
        JLabel Yaş = new JLabel(Yaş);

        JTextField FirstNamefield = new JTextField();
        JTextField LastNamefield = new JTextField();
        JTextField Emailfield = new JTextField();
        JTextField Phonefield = new JTextField();
        JTextField Yaşfield = new JTextField();
        JComboBox comboBox = new JComboBox(new String[]{Male, Female});
        JButton Ode = new JButton(Devam);

        FirstName.setBounds(10, 40, 140, 25);
        LastName.setBounds(10, 80, 80, 25);
        Email.setBounds(240, 40, 100, 25);
        Phone.setBounds(240, 80, 100, 25);
        Gender.setBounds(430, 40, 100, 25);
        FirstNamefield.setBounds(90, 40, 140, 25);
        LastNamefield.setBounds(90, 80, 140, 25);
        Emailfield.setBounds(290, 40, 130, 25);
        Phonefield.setBounds(290, 80, 130, 25);
        comboBox.setBounds(505, 40, 130, 25);
        Yaş.setBounds(430, 80, 130, 25);
        Yaşfield.setBounds(505, 80, 130, 25);
        Ode.setBounds(660, 40, 120, 65);

        odemePanel.add(FirstName);
        odemePanel.add(LastName);
        odemePanel.add(Email);
        odemePanel.add(Phone);
        odemePanel.add(Gender);
        odemePanel.add(FirstNamefield);
        odemePanel.add(LastNamefield);
        odemePanel.add(Emailfield);
        odemePanel.add(Phonefield);
        odemePanel.add(comboBox);
        odemePanel.add(Yaş);
        odemePanel.add(Yaşfield);
        odemePanel.add(Ode);
    }

    private void createCheckInPanel() {
        panel_2 = new JPanel(null);
        panel_2.setBorder(BorderFactory.createTitledBorder(Check-in  Odeme));
        panel_2.setBounds(200, 170, 800, 200);

        JLabel CartNumara = new JLabel(Cart Numara);
        JLabel CartTa = new JLabel(Cart Tarih);
        JLabel CartCvv = new JLabel(CVV);
        JLabel Fiyat = new JLabel(Fiyat);

        JTextField CartNumarafield = new JTextField();
        JTextField CartTafield = new JTextField();
        JTextField CartCvvfield = new JTextField();
        JTextField FiyatField = new JTextField();
        JButton button1 = new JButton(Ode);

        CartNumara.setBounds(20, 40, 140, 25);
        CartNumarafield.setBounds(110, 40, 100, 25);
        CartTa.setBounds(20, 80, 80, 25);
        CartTafield.setBounds(110, 80, 100, 25);
        CartCvv.setBounds(250, 40, 100, 25);
        CartCvvfield.setBounds(320, 40, 100, 25);
        Fiyat.setBounds(250, 80, 100, 25);
        FiyatField.setBounds(320, 80, 100, 25);
        button1.setBounds(500, 40, 120, 65);

        panel_2.add(CartNumara);
        panel_2.add(CartTa);
        panel_2.add(CartCvv);
        panel_2.add(Fiyat);
        panel_2.add(CartNumarafield);
        panel_2.add(CartTafield);
        panel_2.add(CartCvvfield);
        panel_2.add(FiyatField);
        panel_2.add(button1);
    }

    private void createListPanel() {
    	
    	panelList = new JPanel(null);
    	panelList.setBorder(BorderFactory.createTitledBorder(Uçak bileti));
    	panelList.setBounds(200, 170, 800, 200);
    	
    }
    private void fetchDataFromDatabase(DefaultListModelString listModel) {
        String url = jdbcmysqllocalhost3306your_database_name;
        String user = your_username;
        String password = your_password;
        String query = SELECT  FROM your_table_name;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String data = resultSet.getString(your_column_name);
                listModel.addElement(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createTabbedPane() {
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setBounds(200, 170, 800, 200);

        tabbedPane.addTab(Uçak bileti, mainPanel);
        tabbedPane.addTab(Müşteri bilgileri, odemePanel);
        tabbedPane.addTab(Check-in  Odeme, panel_2);
        tabbedPane.addTab(Bilet listesi, panelList);
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame(Turkish Airlines);
        frame.setSize(1220, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel panel2 = new JPanel(null);
        panel2.setBorder(BorderFactory.createTitledBorder(Turkish Airlines));
        panel2.setBounds(0, 0, 1200, 500);

        JLabel bodyLabel = new JLabel(MERHABA,);
        bodyLabel.setFont(new Font(Arial, Font.BOLD, 24));
        bodyLabel.setBounds(380, 0, 450, 200);
        JLabel imageLabel = new JLabel(new ImageIcon(12.jpg));
        imageLabel.setBounds(10, 20, 1180, 330);
        JLabel label5 = new JLabel(Nereyi keşfetmek istersin);
        label5.setFont(new Font(Arial, Font.BOLD, 24));
        label5.setBounds(380, 25, 450, 200);

        panel2.add(label5);
        panel2.add(bodyLabel);
        panel2.add(imageLabel);

        frame.add(tabbedPane);
        frame.add(panel2);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TurkishAirlinesaGUInew);
    }
}
