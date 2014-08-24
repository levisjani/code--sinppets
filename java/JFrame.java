import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;

class JProgressBar_test extends JFrame implements ActionListener{
   
    private JProgressBar jp;
    private JButton[] JBS = new JButton[10];
    private JPanel p1;
    private JTextField JT;
    private int array_count = 0 ;
    private int JProgressBar_UPDATE = 0 ;
   
    public JProgressBar_test()
    {
        setLayout(new FlowLayout());
        setTitle("JProgressBar");
        set_JTextField();
        set_JProgressBar();
        set_JButtons();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,350);
        setResizable(false);
        setVisible(true);
    }
   
    void set_JTextField()
    {
        JLabel g = new JLabel("Write the data into text filed");
        add(g);
        JT = new JTextField(10);
        add(JT);
        JT.addActionListener(this);
    }
   
    void set_JProgressBar()
    {
        jp = new JProgressBar();
        jp.setMinimum(0);
        jp.setMaximum(100);
        jp.setStringPainted(true);
        jp.setBackground(Color.white);
        add(jp);
    }
   
    void set_JButtons()
    {
        p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p1.setBorder(BorderFactory.createTitledBorder("Data Array"));
        for(int i=0;i<10;i++)
        {
            JBS[i]= new JButton();
            JBS[i].setText("["+i+"] = 0");
            p1.add(JBS[i]);
        }
        add(p1);
    }
   
    public void actionPerformed(ActionEvent eve)
    {
        if(array_count<10)
        {
            JBS[array_count].setText("["+array_count+"] = "+JT.getText());
            array_count++;
            JProgressBar_UPDATE+=10;
            jp.setValue(JProgressBar_UPDATE);
        }else{
            jp.setString("Done");
            JOptionPane.showMessageDialog(rootPane,"Data array is full");
            JT.setEditable(false);
        }
    }
}

public class javaapp {
   
    public static void main(String[] args) {
       
        JProgressBar_test jp = new JProgressBar_test();
    }
}
