// import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.jar.JarEntry;


public class Server extends JFrame implements ActionListener{

    JTextField textField;
    JPanel main;
    static Box verticle = Box.createVerticalBox();

    Server(){
        int frameWidth = 450;
        int frameHeight = 700;


        setLayout(null);

        // creating a custom panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(61,137,94));
        panel1.setBounds(0, 0, frameWidth, 70);
        panel1.setLayout(null);
        add(panel1);
        setSize(frameWidth, frameHeight);

        // loacd icon
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = icon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon backIcon = new ImageIcon(i2);

        JLabel back = new JLabel(backIcon);
        back.setBounds(5, 20, 25, 25);
        panel1.add(back);

        // profile image
        ImageIcon pIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image pi2 = pIcon1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon profileIcon = new ImageIcon(pi2);

        JLabel profile = new JLabel(profileIcon);
        profile.setBounds(35, 10, 50, 50);
        panel1.add(profile);

        // video image
        ImageIcon vIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image scaledVideoIcon = vIcon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon videoIcon = new ImageIcon(scaledVideoIcon);

        JLabel videoLabel = new JLabel(videoIcon);
        videoLabel.setBounds(330, 25, 30, 25);
        panel1.add(videoLabel);

        // call image
        ImageIcon cIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image scaledCallIcon = cIcon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon phoneIcon = new ImageIcon(scaledCallIcon);

        JLabel phoneLabel = new JLabel(phoneIcon);
        phoneLabel.setBounds(375, 25, 25, 25);
        panel1.add(phoneLabel);
        
        // menu image
        ImageIcon mIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image scaledMenuIcon = mIcon1.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon MenuIcon = new ImageIcon(scaledMenuIcon);

        JLabel menuLabel = new JLabel(MenuIcon);
        menuLabel.setBounds(415, 25, 10, 25);
        panel1.add(menuLabel);

        // user information
        JLabel user = new JLabel("Waseem");
        user.setBounds(105, 20, 100, 18);
        user.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        user.setForeground(Color.WHITE);
        panel1.add(user);

        // status information
        JLabel status = new JLabel("Available now!");
        status.setBounds(105,40,100,18);
        status.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        status.setForeground(Color.white);
        panel1.add(status);
        // click listener for back button
       back.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae){
            System.exit(0);
        }
       });
       
    //    main panel
       main = new JPanel();
       main.setBounds(5, 75, 428, 525);
       main.setBackground(new Color(227, 245, 235));
       add(main);


    //    adding text field
       textField = new JTextField();
       textField.setBounds(5,605 ,300,50);
       textField.setBackground(Color.WHITE);
       textField.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
       add(textField);

    //    send button
       JButton send = new JButton("Send");
       send.setBounds(305,605, 130,50);
       send.setBackground(new Color(61,137,94));
       send.setForeground(Color.white);
       textField.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       send.addActionListener(this);
       add(send);
       
        // find dimensons
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        // setLocation()
        setLocation((width/2)-(frameWidth/2), (height/2)-(frameHeight/2));
        // change frame color
        getContentPane().setBackground(Color.WHITE);
        // set visible must stay at the end. since we want to set it up first before showing.
        setVisible(true);
    }

    public static void main (String []args) throws Exception{
        new Server();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        String message = textField.getText();
        
        JLabel messageLabel = new JLabel(message);
        JPanel messagePanel = new JPanel();
        messagePanel.add((messageLabel));
        messagePanel.setBackground(new Color(227, 245, 235));
        messagePanel.setForeground(Color.GREEN);
        main.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(messagePanel, BorderLayout.LINE_END);

        right.setBackground(new Color(227, 245, 235));
        verticle.add(right);
        verticle.add(Box.createVerticalStrut(15));

        main.add(verticle,BorderLayout.PAGE_START);
        
        // refresh the page
        repaint();
        invalidate();
        validate();
    }
}
