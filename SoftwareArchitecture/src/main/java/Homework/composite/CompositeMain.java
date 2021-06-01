package Homework.composite;

import java.io.File;

public class CompositeMain {
    public static void main(String[] args) {
        FileGUI gui = new FileGUI();
//        String fileName = "D:/Programs";
//        Directory root = getFileName(fileName);
//        root.printList(fileName.substring(0, fileName.indexOf('/')));
//        try {
//            System.out.println("Making root entries...");
//            Directory rootdir = new Directory("root");
//            Directory bindir = new Directory("bin");
//            Directory tmpdir = new Directory("tmp");
//            Directory usrdir = new Directory("usr");
//            rootdir.add(bindir);
//            rootdir.add(tmpdir);
//            rootdir.add(usrdir);
//            bindir.add(new File("vi", 10000));
//            bindir.add(new File("latex", 20000));
//            rootdir.printList();
//
//            System.out.println("");
//            System.out.println("Making user entries...");
//            Directory lee = new Directory("Lee");
//            Directory wang = new Directory("Wang");
//            Directory liu = new Directory("Liu");
//            usrdir.add(lee);
//            usrdir.add(wang);
//            usrdir.add(liu);
//            lee.add(new File("diary.html", 100));
//            lee.add(new File("Composite.java", 200));
//            wang.add(new File("memo.tex", 300));
//            liu.add(new File("game.doc", 400));
//            liu.add(new File("junk.mail", 500));
//            rootdir.printList();
//            //System.out.println(rootdir.getSize());
//        } catch (FileTreatmentException e) {
//            e.printStackTrace();
//        }
    }

//    public static Directory getFileName(String filePath){
//        if(filePath != null && !filePath.isBlank()){
//            java.io.File file = new java.io.File(filePath);
//            if(!file.exists()){
//                return new Directory(null);
//            }
//            Directory root = new Directory(filePath.substring(filePath.lastIndexOf('/')+1));
//            java.io.File[] fileArray= file.listFiles();
//            if (fileArray != null) {
//                File fileName;
//                for (File value : fileArray) {
//                    fileName = value;
//                    if (fileName.isDirectory()) {
//                        root.add(new Directory(fileName.getName()));
//                    }
//                    else {
//                        root.add(new Homework.composite.File(fileName.getName(), (int)fileName.getTotalSpace()));
//                    }
//                }
//            }
//            return root;
//        }
//        return null;
//    }
}
