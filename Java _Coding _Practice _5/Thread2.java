Thread t = new Thread(new Runnable(){
                        public void run(){
                            random();
                            display(index1);
                            
                            if(isWon() == true){
                                new Winner();
                                tf.setText(String.valueOf(countWin()));
                                label[0].setIcon(new ImageIcon(new ImageIcon(images[index1]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
                                label[1].setIcon(new ImageIcon(new ImageIcon(images[index2]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
                                label[2].setIcon(new ImageIcon(new ImageIcon(images[index3]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
                            }else{
                                tf.setText(String.valueOf(countWin()));
                            }
                            try{
                                Thread.sleep(30000);
                            }catch(InterruptedException ie){}
                        }
                    });
                    t.start();
                    
                /*//CONSTRUCTOR FOR THE SLOT MACHINE
    public SpinGUI2(){
        setTitle("Slot Machine");
        
        for(i=0;i<label.length;i++){
            label[i] = new JLabel(new ImageIcon("7.png"));
        }
        setBorderLayout();
        panel.setLayout(new BorderLayout());
        
        panel.add(label[0], BorderLayout.WEST);
        panel.add(label[1], BorderLayout.CENTER);
        panel.add(label[2], BorderLayout.EAST);
        
        panel2.add(lbl);
        panel2.add(tf);
        tf.setEnabled(false);
        panel2.add(spin);
        spin.addActionListener(this);
        
        //panel.add(panel3, BorderLayout.NORTH);
        panel.add(panel2, BorderLayout.SOUTH);
        
        
        getContentPane().add(panel);
       // setPreferredSize(new Dimension(800,800));
        setBounds(500,150,500,500);
        setVisible(true);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setBorderLayout(){
        for(i=0;i<label.length;i++){
            label[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        }
    }
    public Image randomDisplayImages(){
        rand = (int)(Math.random() * images.length);
        img = Toolkit.getDefaultToolkit().getImage(images[rand]);
        //label.setIcon(new ImageIcon(images[ThreadLocalRandom.current().nextInt(images.length)]));
        return img;
    }
    public void winner(){
        if(label[0].getIcon().equals(label[1].getIcon()) && label[1].getIcon().equals(label[2].getIcon())){
            win++;
            new Winner();
        }
    }
    //ACTION LISTENER FOR THE SPIN BUTTON
    public void actionPerformed(ActionEvent ae){ 
        if(ae.getSource().equals(spin)){
            //THREAD
            
            label[0].setIcon(new ImageIcon(randomDisplayImages()));
            label[1].setIcon(new ImageIcon(randomDisplayImages()));
            label[2].setIcon(new ImageIcon(randomDisplayImages()));
            
            panel.add(label[0], BorderLayout.WEST);
            panel.add(label[1], BorderLayout.CENTER);
            panel.add(label[2], BorderLayout.EAST);
            
            getContentPane().add(panel);
            setVisible(true);
        }
    }

    public static void main(String[] args){
        
    }
}*/    