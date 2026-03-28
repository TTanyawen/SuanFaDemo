package sort;

import java.io.*;
import java.util.*;

public class ExternalSortDemo {

    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";
    private static final String TEMP_DIR = "temp";

    // 每块100MB
    private static final int CHUNK_SIZE = 100 * 1024 * 1024;

    public static void main(String[] args) throws Exception {
        new File(TEMP_DIR).mkdirs();

        // 1. 生成测试文件（500MB）
        generateFile(INPUT_FILE, 500 * 1024 * 1024);

        // 2. 分块排序
        List<File> sortedFiles = splitAndSort(INPUT_FILE);

        // 3. 多路归并
        mergeFiles(sortedFiles, OUTPUT_FILE);

        System.out.println("排序完成！");
    }

   //生成大文件

    public static void generateFile(String fileName, long sizeBytes) throws IOException {
        Random random = new Random();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        long written = 0;
        while (written < sizeBytes) {
            int num = random.nextInt(Integer.MAX_VALUE);
            String line = num + "\n";
            writer.write(line);
            written += line.getBytes().length;
        }

        writer.close();
        System.out.println("文件生成完成：" + fileName);
    }

    //分块读取 ，排序
    public static List<File> splitAndSort(String fileName) throws IOException {
        List<File> files = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        List<Integer> chunk = new ArrayList<>();
        int currentSize = 0;
        int fileIndex = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            chunk.add(Integer.parseInt(line));
            currentSize += line.length() + 1;

            if (currentSize >= CHUNK_SIZE) {
                files.add(writeChunk(chunk, fileIndex++));//加入一个子文件
                chunk.clear();
                currentSize = 0;
            }
        }

        // 最后一块
        if (!chunk.isEmpty()) {
            files.add(writeChunk(chunk, fileIndex++));
        }

        reader.close();
        System.out.println("分块完成，共生成文件：" + files.size());
        return files;
    }

    //排序并写入临时文件
    private static File writeChunk(List<Integer> chunk, int index) throws IOException {
        Collections.sort(chunk);

        File file = new File(TEMP_DIR + "/chunk_" + index + ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for (int num : chunk) {
            writer.write(num + "\n");
        }

        writer.close();
        return file;
    }

    // 多路归并

    public static void mergeFiles(List<File> files, String outputFile) throws IOException {

        // 小顶堆
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n.value));
        List<BufferedReader> readers = new ArrayList<>();

        // 初始化
        // 每个文件只读一个数
        for (int i = 0; i < files.size(); i++) {
            BufferedReader br = new BufferedReader(new FileReader(files.get(i)));
            readers.add(br);

            String line = br.readLine();
            if (line != null) {
                heap.add(new Node(Integer.parseInt(line), i));
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));


        //轮流每个文件读取一个数，每次取出一个最小的数写进输出文件
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            writer.write(node.value + "\n");

            BufferedReader br = readers.get(node.fileIndex);
            String line = br.readLine();

            if (line != null) {
                heap.add(new Node(Integer.parseInt(line), node.fileIndex));
            }
        }

        writer.close();

        // 关闭流
        for (BufferedReader br : readers) {
            br.close();
        }

        System.out.println("归并完成！");
    }


    //堆节点
    static class Node {
        int value;
        int fileIndex;

        Node(int value, int fileIndex) {
            this.value = value;
            this.fileIndex = fileIndex;
        }
    }
}