package nio;

import console.Console;


/**
 * The concrete class of Console class
 * this class is used to input values and show result.
 *
 * @author Thinh Diep
 * @version 1.0
 */
public class NIOConsole implements Console {
    private NIOImpl nioImpl = new NIOImpl();

    @Override
    public void start() {
        inputValues();
        running();
        showResults();

    }

    @Override
    public void inputValues() {

    }

    @Override
    public void running() {

    }

    @Override
    public void showResults() {
        nioImpl.showPathInformation("E:\\TestNewIO");
        nioImpl.showFilesInformation("E:\\TestNewIO\\Test2.txt");
        nioImpl.copyFiles("E:\\TestNewIO\\Test2.txt", "E:\\TestNewIO\\Child\\TestCopy2.txt");
    }
}
