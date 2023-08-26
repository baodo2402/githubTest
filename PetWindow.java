import javax.swing.*;
import java.awt.event.*;
import model.*;
//hello world!!!
// hello world again
public class PetWindow extends JFrame
{
    private Pet pet = new Pet(); //declare the model object first!
    private MyPanel panel = new MyPanel();
    public PetWindow()
    {
       super("Pet Store");
       setup();
       build();
       setVisible(true);
    }
    private void setup()
    {
        setSize(300, 100);
        setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void build()
    {
        add(panel);
    }
    private class MyPanel extends JPanel implements MyObserver //step 3
    {
        private JLabel id = new JLabel("Id:");
        private JTextField petId = new JTextField(2);
        private JLabel name = new JLabel("Pet Name:");
        private JTextField petName = new JTextField(10);
        private JButton set = new JButton("Set");
        private JLabel label = new JLabel();
        public MyPanel()
        {
            setup();
            build();
            pet.attach(this);//step 4
        }
        private void setup()
        {
            set.addActionListener(new PetListener());
        }
        private void build()
        {
            add(id);
            add(petId);
            add(name);
            add(petName);
            add(set);
            add(label);
        }
        public void update() //step 3
        {
                label.setText("Pet Saved: " + pet.toString());
        }
        private class PetListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                int id = Integer.parseInt(petId.getText());
                String name = petName.getText();
                pet.set(id, name);
            }
        }
    }
    
}
