import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        // ファイル選択の初期位置
        File targetFile = null;

        // カレントディレクトリの最も正しい表現
        try {
            targetFile = new File((new File(".").getCanonicalPath()));
        } catch (Exception e) {
            System.out.println("null文字列が渡された場合、ファイル・チューザはユーザーのデフォルト・ディレクトリを参照します");
        }

        // ファイル選択要クラス
        JFileChooser filechooser = new JFileChooser(targetFile);

        // フィルタを作成
        FileFilter filter1 = new FileNameExtensionFilter("CSV", "csv");
        FileFilter filter2 = new FileNameExtensionFilter("TEXT", "txt");
        FileFilter filter3 = new FileNameExtensionFilter("HTML", "html", "htm");

        // フィルタを追加( 全てのファイルはデフォルトで作成されている )
        filechooser.addChoosableFileFilter(filter1);
        filechooser.addChoosableFileFilter(filter2);
        filechooser.addChoosableFileFilter(filter3);

        // 選択するパス
        filechooser.setFileFilter(filter1);
    
        // 開く
        int ret = filechooser.showOpenDialog(null);
        // ファイルを選択
        if (ret == JFileChooser.APPROVE_OPTION){
            File file = filechooser.getSelectedFile();
            String path = file.getAbsolutePath();
            System.out.println(path);
        }
        // キャンセル
        if (ret == JFileChooser.CANCEL_OPTION){
            System.out.println("キャンセルされました");
        }
  
    }
}
