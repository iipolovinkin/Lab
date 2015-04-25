package ru.blogspot.feomatr.lab.commons;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by feo on 26.03.15.
 */
public class SyncDoc {
    private static List<File> subDirs;
    private static List<File> subDirs2;

    private static String dir = "/home/feo/data/sufd-func/Func/docs";
    private static String docType;
    private static String dir2 = "/home/feo/data/STAND/sufd.config/forms";

    public static void main(String[] args) {
        String[] names = new String[]{"ZKR", "DICTACCINFO"};

        subDirs = getListOfDirectories(dir);
        subDirs2 = getListOfDirectories(dir2);
        testSort(subDirs2);
        for (int i = 0; i < names.length; i++) {
            setDocType(names[i]);
            Collection<File> docTypeFile = Collections2.filter(subDirs, getDocTypePredicat() );
            Collection<File> docTypeFile2 = Collections2.filter(subDirs2, getDocTypePredicat() );
            System.out.println(docTypeFile);
            System.out.println(docTypeFile2);

            File d1 = docTypeFile.iterator().next();
            File d2 = docTypeFile2.iterator().next();
            try {
                FileUtils.copyDirectory(d1, d2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Predicate<? super File> getDocTypePredicat() {
        return new Predicate<File>() {
            @Override
            public boolean apply(File input) {
                String absolutePath = input.getAbsolutePath();
                if (!(absolutePath.endsWith("/" + getDocType() + "") && !absolutePath.contains("integration"))) {
                    return false;
                }
                return true;
            }
        };
    }

    public static List<File> getListOfDirectories(String dir) {
        List<File> result = Lists.newArrayList();
        File directory = new File(dir);
        Collection<File> files = FileUtils.listFilesAndDirs(directory, EmptyFileFilter.EMPTY, DirectoryFileFilter.DIRECTORY);
        Iterator<File> f = files.iterator();
        while (f.hasNext()) {
            File file = f.next();
            result.add(file);
        }
        return result;
    }

    static void testSort(List<File> subDir){
        List<File> subdir1 = new ArrayList<File>(subDir.subList(0, 20));
        List<File> subdir2 = new ArrayList<File>(subDir.subList(0, 20));

        Collections.sort(subdir2, new Comparator<File>() {
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        String format = "%1$20s   |   %2$20s";
        System.out.println(String.format(format, "natural", "ordered"));
        for (int i = 0; i < subdir1.size(); i++) {
//            System.out.println( subdir1.get(i).getName() + " , "+ subdir2.get(i).getName());
            System.out.println(String.format(format, subdir1.get(i).getName(), subdir2.get(i).getName()));
        }


//        System.out.println(String.format("%d", Calendar.getInstance()));

        //java 1.8
        subdir2.forEach(new Consumer<File>() {
            public void accept(File file) {
                System.out.println(file.getName());
            }
        });
//        System.out.println("subDirs2 = " + subdir2);

    }
    public static String getDocType() {
        return docType;
    }

    public static void setDocType(String docType) {
        SyncDoc.docType = docType;
    }


}
