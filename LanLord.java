package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class LanLord {

	private static  final String SINGLE = "single";
	private static  final String DOUBLE = "double";
	private static  final String TRIPLE = "triple";
	private static  final String TRIPLE_AND_DOUBLE = "triple_and_double";
	private static  final String TRIPLE_AND_OTHER = "triple_and_other";
	private static  final String FORTH = "forth";
	private static  final String FORTH_AND_DOUBLE = "forth_and_double";
	private static final String FORTH_AND_OTHER = "forth_and_other";
	private static  final String KING_BOOOM ="king_booom";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LanLord ll = new LanLord();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String myCard = sc.nextLine();
			String op = sc.nextLine();
			if (ll.ifIWin(op, myCard)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
		}
	}
	
	public Map stringToMap(String card) {		
		int i = 0;
		String[] cards = card.split(" "); 
		HashMap cntNumber = new HashMap();
		for(i = 0; i < cards.length; i++) {
			if(cards[i].equals("JOKER")) {
				cntNumber.put(17, 1);					
			} else if(cards[i].equals("joker")) {
				cntNumber.put(16, 1);		
			} else {
				if(cntNumber.containsKey(Integer.parseInt(cards[i]))) {
					int num = (Integer)cntNumber.get(Integer.parseInt(cards[i]));
					cntNumber.put(Integer.parseInt(cards[i]), num + 1);
				} else {
					cntNumber.put(Integer.parseInt(cards[i]), 1);
				}						
			}
		}
		return cntNumber;
	}
	
	private Card opponentCards(HashMap cards) {
		Card card = new Card();
		Iterator it = cards.entrySet().iterator();
		int size = cards.size();
		if(size == 1) {
			Map.Entry en = (Entry) it.next();
			int num = (Integer)en.getValue();
			int type = (Integer)en.getKey();
			int score = (int) (Math.pow(10, (num - 1) * 2) * type);
			card.score = score;
			if(score < 30) {
				card.type = SINGLE;
			} else if(score >= 300 && score < 1600) {
				card.type = DOUBLE;
			} else if(score >= 30000 && score < 160000) {
				card.type = TRIPLE;
			} else {
				card.type = FORTH; 
			}
		} else if(size == 2) {
			int score = 0;
			int cntMin = 10;
			int cntKing = 0;
			while(it.hasNext()) {
				Map.Entry en = (Entry) it.next();
				int num = (Integer)en.getValue();
				int type = (Integer)en.getKey();
				if(type == 16 || type == 17) {
					cntKing++;
				}
				if(num < cntMin) {
					cntMin = num;
				}
				score += (int) (Math.pow(10, ((num - 1) * 2)) * type);
			}
			if(cntKing == 2) {
				card.type = KING_BOOOM;
				return card;
			}
			card.score = score;
			if( score < 165000) {
				card.type = TRIPLE_AND_DOUBLE;
			} else if(score > 165000) {
				if(cntMin == 1 ) {
					card.type = FORTH_AND_OTHER;
				} else {
					card.type = FORTH_AND_DOUBLE;
				}
			}			
		} else {
			int score = 0;
			int cntMin = 10;
			while(it.hasNext()) {
				Map.Entry en = (Entry) it.next();
				int num = (Integer)en.getValue();
				int type = (Integer)en.getKey();
				if(num < cntMin) {
					cntMin = num;
				}
				score += (int) (Math.pow(10, (num - 1) * 2) * type);
			}
			card.score = score;
			card.type = FORTH_AND_OTHER;
		}
		return card;	
	}
	
	private boolean iHaveKingBooom(String myCard) {
		int cnt = 0;
		String[] myCards = myCard.split(" ");
		for(String c : myCards) {
			if(c.equals("joker") || c.equals("JOKER")) {
				cnt++;
			}
		}
		return cnt == 2;
	}
	
	private boolean ifHaveBooom(Iterator it) {
		while(it.hasNext()) {
			Map.Entry en = (Entry) it.next();
			int num = (Integer)en.getValue();
			if(num == 4) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean ifIWin(String ops, String myCard) {
		boolean iWin = false;
		boolean iHaveBooom = false;
		Card op = opponentCards( (HashMap) stringToMap(ops));
		if (op.type.equals(KING_BOOOM)) {
			return iWin;
		} 
		if(iHaveKingBooom(myCard)) {
			return true;
		}
		HashMap mycardMap = (HashMap) stringToMap(myCard);
		Iterator it = mycardMap.entrySet().iterator();
		iHaveBooom = ifHaveBooom(it);
		it = mycardMap.entrySet().iterator();
		if(op.type.equals(SINGLE)) {
			if(iHaveBooom) {
				return true;
			}
			int score = 0;
			while(it.hasNext()) {
				Map.Entry en = (Entry) it.next();
				int num = (Integer)en.getValue();
				int type = (Integer)en.getKey();
				if(type > op.score) {
					iWin = true;
					break;
				}
			}
		} else if(op.type.equals(DOUBLE)) {
			if(iHaveBooom) {
				return true;
			}
			int score = 0;
			while(it.hasNext()) {
				Map.Entry en = (Entry) it.next();
				int num = (Integer)en.getValue();
				int type = (Integer)en.getKey();
				if(num == 2) {
					score = (int) (Math.pow(10, (num - 1) * 2) * type);
					if(score > op.score) {
						iWin = true;
						break;				
					}
				}
			}
		} else if(op.type.equals(TRIPLE)) {
			if(iHaveBooom) {
				return true;
			}
			int score = 0;
			while(it.hasNext()) {
				Map.Entry en = (Entry) it.next();
				int num = (Integer)en.getValue();
				int type = (Integer)en.getKey();
				if(num == 3) {
					score = (int) (Math.pow(10, (num - 1) * 2) * type);
					if(score > op.score) {
						iWin = true;
						break;				
					}
				}
			}
		} else if(op.type.equals(FORTH) || op.type.equals(FORTH_AND_OTHER)) {
			if(op.type.equals(FORTH_AND_OTHER)) {
				if(iHaveBooom) {
					return true;
				}
			}
			int score = 0;
			while(it.hasNext()) {
				Map.Entry en = (Entry) it.next();
				int num = (Integer)en.getValue();
				int type = (Integer)en.getKey();
				if(num == 4) {
					score = (int) (Math.pow(10, (num - 1) * 2) * type);
					if(score > op.score) {
						iWin = true;
						break;				
					}
				}
			}
		} else if(op.type.equals(TRIPLE_AND_DOUBLE)) {
			if(iHaveBooom) {
				return true;
			}
			int score = 0;
			boolean haveDouble =false;
			boolean tripleGood = false;
			while(it.hasNext()) {
				Map.Entry en = (Entry) it.next();
				int num = (Integer)en.getValue();
				int type = (Integer)en.getKey();
				if(haveDouble && tripleGood) {
					iWin = true;
					break;		
				}				
				if(num == 2) {
					haveDouble = true;
					continue;
				}
				if(num == 3) {
					score = (int) (Math.pow(10, (num - 1) * 2) * type);
					if(score > op.score) {
						tripleGood = true;		
					}
				}
			}
			if(haveDouble && tripleGood) {
				iWin = true;		
			}	
		} else if(op.type.equals(FORTH_AND_DOUBLE)) {
			if(iHaveBooom) {
				return true;
			}
			int score = 0;
			boolean haveDouble =false;
			boolean forthGood = false;
			while(it.hasNext()) {
				Map.Entry en = (Entry) it.next();
				int num = (Integer)en.getValue();
				int type = (Integer)en.getKey();
				if(haveDouble && forthGood) {
					iWin = true;
					break;		
				}				
				if(num == 2) {
					haveDouble = true;
					continue;
				}
				if(num == 4) {
					score = (int) (Math.pow(10, (num - 1) * 2) * type);
					if(score > op.score) {
						forthGood = true;		
					}
				}
			}
			if(haveDouble && forthGood) {
				iWin = true;	
			}	
		}
		return iWin;
	}
	
	class Card {
		int score;
		String type;
	}

}
