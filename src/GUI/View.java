
package GUI;

import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author 91898
 */
public class View extends JFrame implements ActionListener {
    JButton CompressButton;
    JButton DeCompressButton;
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        CompressButton =new JButton("select file to compress");
        CompressButton.addActionListener(this);
        CompressButton.setBounds(20, 100, 200, 30);
        
        DeCompressButton =new JButton("select file to decompress");
        DeCompressButton.addActionListener(this);
        DeCompressButton.setBounds(250, 100, 200, 30);
        
        this.add(CompressButton);
        this.add(DeCompressButton);
      this.getContentPane().setBackground(Color.LIGHT_GRAY);
      
        
        
        
        this.setSize(500,200);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==CompressButton)
        {
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            
            if(response ==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Compress.method(file);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.toString());
            }
                
            }
        }
            if(e.getSource()==DeCompressButton)
            {
            JFileChooser fileChooser=new JFileChooser();
                
            int response=fileChooser.showSaveDialog(null);
            
            if(response ==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.method(file);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.toString());
            }
                
            }
        }
        
    }
    public static void main(String[] args)
    {
        View view=new View();
        view.setVisible(true);
    }
    
    
}
