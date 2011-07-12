package com.petradesigns.backingbean;

public class HelloWorldInteractive {

    private String outputText = "Hello World";
    private String name = "";
    
    public String getOutputText() {
        return outputText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String display() {
        System.out.println("display()");
        outputText = name + ", " + outputText;        
        return "greeting";
    }


}
