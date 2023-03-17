package com.nato_code;

public final class NatoCode {

    public static enum Symbol {
	Alphabet(0), Word(1), Korea(2), Morse(3);

	public final int number;

	private Symbol(int point) {
	    this.number = point;
	}
    }

    private static String[][] code_map = { //
	    { "A", "ALPHA", "알파", ".-" }, //
	    { "B", "BRAVO", "브라보", "-..." }, //
	    { "C", "CHARLIE", "찰리", "-.-." }, //
	    { "D", "DELTA", "델타", "-.." }, //
	    { "E", "ECHO", "에코", "." }, //
	    { "F", "FOXTROT", "폭스트롯", "..-." }, //
	    { "G", "GOLF", "골프", "--." }, //
	    { "H", "HOTEL", "호텔", "...." }, //
	    { "I", "INDIA", "인디아", ".." }, //
	    { "J", "JULIETT", "쥴리엣", ".---" }, //
	    { "K", "KILO", "킬로", "-.-" }, //
	    { "L", "LIMA", "리마", ".-.." }, //
	    { "M", "MIKE", "마이크", "--" }, //
	    { "N", "NOVEMBER", "노벰버", "-." }, //
	    { "O", "OSCAR", "오스카", "---" }, //
	    { "P", "PAPA", "파파", ".--." }, //
	    { "Q", "QUEBEC", "퀘벡", "--.-" }, //
	    { "R", "ROMEO", "로미오", ".-." }, //
	    { "S", "SIERRA", "시에라", "..." }, //
	    { "T", "TANGO", "탱고", "-" }, //
	    { "U", "UNIFORM", "유니폼", "..-" }, //
	    { "V", "VICTOR", "빅터", "...-" }, //
	    { "W", "WHISKY", "위스키", ".--" }, //
	    { "X", "XRAY", "엑스레이", "-..-" }, //
	    { "Y", "YANKEE", "양키", "-.--" }, //
	    { "Z", "ZULU", "줄루", "--.." }, //
	    { "1", "ONE", "원", ".----" }, //
	    { "2", "TWO", "투", "..---" }, //
	    { "3", "THREE", "트리", "...--" }, //
	    { "4", "FOUR", "포어", "....-" }, //
	    { "5", "FIVE", "파이프", "....." }, //
	    { "6", "SIX", "식스", "-...." }, //
	    { "7", "SEVEN", "세븐", "--..." }, //
	    { "8", "EIGHT", "에잇", "---.." }, //
	    { "9", "NINER", "나이너", "----." }, //
	    { "0", "ZERO", "제로", "-----" }//
    };

    public NatoCode() {

    }

    public String codeChange(String code, Symbol search, Symbol change) {
	for (int number = 0; number < code_map.length; number++) {
	    if (code_map[number][search.number].equals(code)) {
		return code_map[number][change.number];
	    }
	}
	return null;
    }

    public String get(String code, Symbol symbol) {
	for (int number = 0; number < code_map.length; number++) {
	    for (int search = 0; search != code_map[0].length; search++) {		
		if (code_map[number][search].equals(code)) {
		    return code_map[number][symbol.number];
		}		
	    }
	}
	return null;
    }

    public String compiler(String code, Symbol symbol) {
	StringBuffer sb = new StringBuffer();
	char[] c = code.toCharArray();
	for (int a = 0; a < c.length; a++) {
	    sb.append(get(c[a] + "", symbol));
	    sb.append(" ");
	}
	return sb.toString();
    }

    private static int code(int count, int line, char[] code) {
//		System.out.println("count" + count + " = code[" + line + "]" + code[line]);

	switch (code[line]) {
	case ' ':
	    return count;
	case '-':
	    count += line;
	    break;
	case '.':
	    count -= line;
	    count += 10;
	    break;
	}
	line += 1;
	return code(count, line, code);
    }

    public static void screen() {
	char[][] code = new char[code_map.length][];
	int[] line = new int[code_map.length];

	for (int a = 0; a < code_map.length; a++) {
	    code[a] = code_map[a][3].toCharArray();
	    line[a] = a;
	    System.out.print(a + "=");
	    for (int c = 0; c < code[a].length; c++) {
		System.out.print(code[a][c]);
	    }
	    System.out.println("");
	}

	char[] code2;

	for (int a = 0; a < code_map.length; a++) {
	    System.out.print(a + " => ");
	    code2 = new char[code[a].length + 1];
	    System.arraycopy(code[a], 0, code2, 0, code[a].length);
	    code2[code2.length - 1] = ' ';
	    for (int c = 0; c < code2.length; c++) {
		System.out.print(code2[c]);
	    }
	    System.out.print(code(0, 0, code2));
	    System.out.println("");
	}
    }

    public static void main(String[] args) {
	screen();
	NatoCode mc = new NatoCode();
	String code = "M";
	System.out.println(mc.get(code, Symbol.Alphabet));
	System.out.println(mc.get(code, Symbol.Word));
	System.out.println(mc.get(code, Symbol.Korea));
	System.out.println(mc.get(code, Symbol.Morse));

	System.out.println(mc.compiler("JANGHYOCHEON123", Symbol.Alphabet));
	System.out.println(mc.compiler("JANGHYOCHEON123", Symbol.Word));
	System.out.println(mc.compiler("JANGHYOCHEON123", Symbol.Korea));
	System.out.println(mc.compiler("JANGHYOCHEON123", Symbol.Morse));
	

    }

}
