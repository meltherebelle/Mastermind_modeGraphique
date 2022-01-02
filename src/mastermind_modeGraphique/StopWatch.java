/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_modeGraphique;

/**
 *
 * @author leaburriat
 */
public class StopWatch {

  private long startTime = 0;
  private long stopTime = 0;
  private boolean running = false;


  public void start() {
    this.startTime = System.currentTimeMillis();
    this.running = true;
  }


  public void stop() {
    this.stopTime = System.currentTimeMillis();
    this.running = false;
  }

}