package ポーカー;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Change {
    private User user;
    private Trump trump;

    public Change(User user, Trump trump) {
        this.user = user;
        this.trump = trump;
    }

    // カード交換処理
    public void exchangeCards() {
    	
        Scanner sc = new Scanner(System.in); 
        System.out.println("捨てる札の番号をスペース区切りで入力してください (例: 1 3 5)。無ければ0を入力してください。");
        
        // ユーザーからの入力を文字列として取得
        String input = sc.nextLine(); 
        
        // 入力された文字列をスペースで分割し、文字列配列に格納
        String[] indices = input.split(" ");
        
        // 捨てる札の番号を格納するリスト
        List<Integer> discardIndices = new ArrayList<>(); 
       
        // 入力された番号が整数であるか、範囲内であるかをチェック
        try {
            for (String index : indices) {
                int discardIndex = Integer.parseInt(index); // 文字列を整数に変換
                if (discardIndex < 1) { // 0が入力された場合はループを抜ける
                    break;
                }
                discardIndices.add(discardIndex); // 捨てる札の番号をリストに追加
            }
        } catch (NumberFormatException e) {
            System.out.println("無効な入力です。"); // 整数じゃないとき
            return;
        }

        // 札を捨てる処理
        List<String> discardCards = new ArrayList<>();
        discardIndices.sort(Collections.reverseOrder()); // 捨てる札の番号リストを降順にソート

        for (int index : discardIndices) {
            int actualIndex = index - 1; // 実際のインデックス

            if (actualIndex >= 0 && actualIndex < user.getHand().size()) {
                discardCards.add(user.getHand().remove(actualIndex)); // 指定されたインデックスの札を捨て、捨てられた札リストに追加
            } else {
                System.out.println("無効な番号:" + index + "はスキップされました。"); // 無効な番号が指定された場合はエラーメッセージを表示
            }
        }
        // 山札から新しい札を引く処理
        List<String> newCards = user.getHand(); 
        for (int i = 0; i < discardCards.size(); i++) {
        	// 山札から新しい札を引く
                newCards.add(trump.getDeck().remove(0));
        }
        
        user.setHand(newCards); // 新しい札を手札に追加
        user.displayHand();

    }

}
