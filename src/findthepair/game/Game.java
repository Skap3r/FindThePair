
package findthepair.game;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import findthepair.SetImage;
import java.util.Collections;
import javax.swing.JLabel;

/**
 *All the game mechanics included in this class.
 * @author Skaper
 */
public class Game {
    private static Random random;
    private static List<Short> list;
    private static JLabel[] allLabels;
    private static JLabel lastLabel;
    private static short lastPosition = 0;
    private static short counter = 0;
    private static boolean once = true;
    private static boolean clear = false;
    
    public void createList() {
        list = new ArrayList();
        
        for (int i = 1; i <= 8; i++) {
            for (int j = 0; j < 2; j++) {
                list.add((short)i);
            }
        }
        System.out.println("before shuffle: " +list);
        
        Collections.shuffle(list);
        
        System.out.println("after shuffle: " +list);
    }
    
    public void letsPlay(short position, JLabel name) {
        if (clear) {
            clearNonActiveLabels(allLabels);
            clear = false;
        }
            
        
        
        name.setText(Short.toString(list.get(position - 1)));
        
        if (once) {
            once = false;
        } else {
            if (lastPosition == list.get(position - 1)) {
                lastLabel.setEnabled(false);
                name.setEnabled(false);
                clear = true;
                once = true;
            } else {
                clear = true;
                once = true;
            }
        }
        
        lastPosition = list.get(position - 1);
        lastLabel = name;
        
//        clearNonActiveLabels(allLabels);
    }
    
    public boolean checkIfAllDisabled() {
        
        if (allLabels != null) {
            for (JLabel label: allLabels) {
                if (label.isEnabled())
                    return false;
            }

            return true;
        }
        
        return false;
    }
    
    private void clearNonActiveLabels(JLabel ... labels) {
        
        for (JLabel label: labels) {
            if (label.isEnabled())
                label.setText(null);
        }
    }
    
    public void listOfLabels(JLabel ... labels) {
        allLabels = new JLabel[16];
        int i = 0;
        for (JLabel name: labels) {
            allLabels[i] = name;
            i++;
        }
    }
}
