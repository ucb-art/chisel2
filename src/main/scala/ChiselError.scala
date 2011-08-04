package Chisel {

import scala.collection.mutable.ArrayBuffer;

object ChiselError {
  val ChiselErrors = new ArrayBuffer[ChiselError];
}

class ChiselError(err: String, m: String, st: Array[StackTraceElement]) {
  var index: Int = 0;
  def printError = {
    println("  " + err + ": " + m);  
    println("     " + (if(index != 0) st(index).toString else "") + "\n");
  }
}

object IllegalArgument {
  def apply(m: String, index: Int): ChiselError = {
    val res = new ChiselError("Illegal Argument", m, Thread.currentThread.getStackTrace);
    res.index = index;
    res
  }
}

object IllegalState {
  def apply(m: String, index: Int): ChiselError = {
    val res = new ChiselError("Illegal State", m, Thread.currentThread.getStackTrace);
    res.index = index;
    res
  }
}

object IllegalName {
  def apply(m: String): ChiselError = {
    new ChiselError("Illegal Name", m, Thread.currentThread.getStackTrace);
  }
}

}