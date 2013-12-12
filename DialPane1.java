/********************************
* User Interface where users can input the Month, Day, Year,
* Latitude, Longitude, and Time Zone.
*
* Sources include:
* http://www.dreamincode.net/forums/topic/17705-basic-gui-concepts/
* @ Authors: Chriselle TOguchi, Eric Tomiyasu, Lawton Takaesu
* @ Date: Fall 2013
* @ Version: 2.0
*/


//package sundial;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.print.*;

public class dialpane1 extends JFrame {
  
        
        private static final int WIDTH = 450;
        private static final int HEIGHT = 274;
        
        private JLabel monthL, dayL, yearL, timeZoneL, latL, longL;
        private JTextField yearTF, latTF, longTF;
        private JComboBox monthCB, dayCB, timezoneCB;
        private JButton submitB, exitB, printB, clearB;
        
        
        //Button handlers:
        private SubmitButtonHandler sbHandler;
        private ExitButtonHandler ebHandler;
        private PrintButtonHandler pbHandler;
        private ClearButtonHandler cbHandler;
        
        //Array of standard meridians
        private int[] meridians;
        
        
        public dialpane1()
        {
        	meridians = new int[] {0, 15, 30, 45, 60, 75, 90, 105, 120, 135, 150, 165, 180, -180, -165, -150, -135, -120, -105, -90, -75, -60, -45, -30, -15 };
        	
        	monthL = new javax.swing.JLabel();
            dayL = new javax.swing.JLabel();
            yearL = new javax.swing.JLabel();
            timeZoneL = new javax.swing.JLabel();
            latL = new javax.swing.JLabel();
            longL = new javax.swing.JLabel();
            latTF = new javax.swing.JTextField();
            longTF = new javax.swing.JTextField();
            yearTF = new javax.swing.JTextField();
            monthCB = new javax.swing.JComboBox();
            dayCB = new javax.swing.JComboBox();
            submitB = new javax.swing.JButton();
            clearB = new javax.swing.JButton();
            exitB = new javax.swing.JButton();
            timezoneCB = new javax.swing.JComboBox();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Sundial Input");
            setFocusCycleRoot(false);
            setName("dialpane"); // NOI18N
            setResizable(false);

            monthL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            monthL.setText("Month:");

            dayL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            dayL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            dayL.setText("Day:");

            yearL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            yearL.setText("Year:");

            timeZoneL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            timeZoneL.setText("Time Zone:");

            latL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            latL.setText("Latitude:");

            longL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            longL.setText("Longitude:");

            latTF.setColumns(10);
            latTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            latTF.setToolTipText("Input the latitude of your current location");
          
            longTF.setColumns(10);
            longTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            longTF.setToolTipText("Input the longitude of your current location");

            yearTF.setColumns(4);
            yearTF.setToolTipText("Input the year");

            monthCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
            monthCB.setToolTipText("Select the month");

            dayCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
            dayCB.setToolTipText("Select the day");

            submitB.setText("Submit");
            submitB.setToolTipText("Submit");

            clearB.setText("Clear");
            clearB.setToolTipText("Clear");

            exitB.setText("Exit");
            exitB.setToolTipText("Exit");

            timezoneCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UTC", "UTC +1 ", "UTC +2", "UTC +3", "UTC +4", "UTC +5", "UTC +6", "UTC +7", "UTC +8", "UTC +9", "UTC +10", "UTC +11", "UTC +12", "UTC -12", "UTC -11", "UTC -10", "UTC -9", "UTC -8", "UTC -7", "UTC -6", "UTC -5", "UTC -4", "UTC -3", "UTC -2", "UTC -1" }));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(timeZoneL)
                        .addComponent(latL)
                        .addComponent(longL)
                        .addComponent(submitB)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(monthL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(monthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(dayL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(yearL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(latTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(longTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(clearB)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(exitB))
                        .addComponent(timezoneCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(40, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monthL, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addComponent(monthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dayL)
                        .addComponent(dayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yearL)
                        .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeZoneL, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addComponent(timezoneCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(latL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(latTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(longL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(longTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(submitB)
                        .addComponent(clearB)
                        .addComponent(exitB))
                    .addContainerGap())
            );

             
                setSize(WIDTH, HEIGHT);
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        
        JFrame frameToPrint;
        public dialpane1(JFrame f){
                frameToPrint = f;
        }
        
        public void Printpage(){
                JFrame frame = new JFrame("Sundial Print");
                frame.setContentPane(new DrawPane());
                frame.setSize(700,700);
                frame.setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                
                JPanel buttonCenter = new JPanel( new FlowLayout(FlowLayout.CENTER) );
         printB = new JButton("Print This Window");
         pbHandler = new PrintButtonHandler();
         printB.addActionListener(pbHandler);

         printB.setVisible(true);
         buttonCenter.add(printB);
        
         frame.add(buttonCenter, BorderLayout.SOUTH);
                
        }

        
        
        
        private class SubmitButtonHandler implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                
                        //Opens new window to print Sundial
                        if(e.getSource() instanceof JButton){
                                Printpage();
                        }
                }
                
        }
        
        private class ExitButtonHandler implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                        System.exit(0);
                }
                
        }
        
        /**
         * Action listener to clear all input fields and set combo boxes back to default values
         */
        private class ClearButtonHandler implements ActionListener
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		String clear = new String("");
        		
        		monthCB.setSelectedIndex(0);
        		dayCB.setSelectedIndex(0);
        		yearTF.setText(clear);
        		latTF.setText(clear);
        		longTF.setText(clear);
        	}
        }
        
        private class PrintButtonHandler implements Printable, ActionListener
        {
            public void actionPerformed(ActionEvent e) {
		        PrinterJob job = PrinterJob.getPrinterJob();
		        job.setPrintable(this);
		        boolean ok = job.printDialog();
		        if (ok) {
			        try {
			        	job.print();
			        } catch (PrinterException ex) {
			        	/* The job did not successfully complete */
			        }
		        }
    
            }
                
	        public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
                DrawPane d = new DrawPane();
	                
		         if (page > 0) {
		        	 return NO_SUCH_PAGE;
		         }
		         d.paint(g);
		        
		         return PAGE_EXISTS;
	        }
        }
        
        
        //Calculates Adjusted Hour lines and Draws
        public class DrawPane extends JPanel{
                public void paint(Graphics g){
                g.drawArc(90,90,500,500,0,180);//Semi Circle
                
                double longitude, latitude, hour, eotAdjust, timeZoneAdjust;
                double [] hourAngle = new double [7];
                int m , d, yr, x, y;
                int tzone;
                //Create instance of hourLine
                hourLine2 gMon = new hourLine2();
                                
                //Assigns data that is entered into the fields.
                try{
                        longitude = Double.parseDouble(longTF.getText());
                        latitude = Double.parseDouble(latTF.getText());
                        m = monthCB.getSelectedIndex() + 1;
                        d = dayCB.getSelectedIndex() + 1;
                        yr = Integer.parseInt(yearTF.getText());
                        tzone = timezoneCB.getSelectedIndex();
                        if(!checkDate(m, d, yr))
                        	throw new NumberFormatException();
                }
                catch(NumberFormatException e){
                 Font font = new Font("Arial", Font.PLAIN, 20);
                 g.setFont(font);
                        g.drawString("Input Error! Please close window", 200, 340);
                        return;
                }

                //Calculates the Equation of Time given the date
                eot eot = new eot();
                eotAdjust = eot.EqOfT(m, d, yr);
                //Calculates Time Zone Adjustments
                timeZoneAdjust = gMon.longitudeCorrection(longitude, tzone);
                
                //Loop through array and transfer to hourAngle array
                        for(int i = 6; i <= 12 ; i++){
                                hour = gMon.calculateTime(latitude) [i-6];
                                hourAngle[i-6] = hour;
                        //System.out.println("Calculated Hour " + i + " is: " + hourAngle[i-6]);
                        }
                
                        //Draws the AM hour lines
                        for(int i = 0; i <= 6 ; i++){
                                x = (int) (340 - 250 * Math.cos(Math.toRadians(hourAngle[i])));
                                x = x - (int) eotAdjust + (int) timeZoneAdjust;
                                System.out.println("x -> " + x);
                                y = (int) (340 - 250 * Math.sin(Math.toRadians(hourAngle[i])));
                                y = y - (int) eotAdjust + (int) timeZoneAdjust;
                                System.out.println("y-> " + y);
                                g.drawLine(x, y, 340, 340);
                        
                        }
                
                        //Draws the PM hour lines
                        for(int i = 1; i <= 6 ; i++){
                                y = (int) (340 - 250 * Math.sin(Math.toRadians(hourAngle[i])));
                                y = y - (int) eotAdjust + (int) timeZoneAdjust;
                                System.out.println("y-> " + y);
                                x = (int) (340 + 250 * Math.cos(Math.toRadians(hourAngle[i])));
                                x = x + (int) eotAdjust - (int) timeZoneAdjust;
                                g.drawLine(x, y, 340, 340);
                        }
                
                //Creates Gnomon coordinates based on the Latitude
                int gx = (int) (340 - 250 * Math.cos(Math.toRadians(latitude)));
                int gy = (int) (590 - 250 * Math.sin(Math.toRadians(latitude)));
                
                //Draws Gnomon
                g.drawLine(90,590,340,590);
                g.drawLine(340, 590, gx, gy);
                g.drawLine(gx,gy,90,590);

                }
                
                /**
                 * Helper function to determine if the inputed date is valid.
                 * Takes into account leap years.
                 * @param month	- inputed month
                 * @param day	- inputed day
                 * @param year	- inputed year
                 * @return true if the date is valid, false otherwise
                 */
                private boolean checkDate(int month, int day, int year){
                	
                	boolean result = true;
                	
                	//check if month == February and if it is a leap year
                	if(month == 2){
                		if(year % 4 != 0 && day > 28){
                			result = false;
                		}
                		else if (year % 4 == 0 && day > 29){
                			result = false;
                		}
                	}
                	else{
                		//even months before July all have 30 days
                		if(month % 2 == 0 && month < 7 && day > 30){
                			result = false; 
                		}
                		//odd months after July have 30 days
                		else if (month % 2 == 1 && month > 7 && day > 30){
                			result = false;
                		}
                	}
                	
                	
                	return result;
                }
                
        }
        
        //Main
        public static void main(String[] args)
        {
                dialpane1 input = new dialpane1();
                
        } 
        
}