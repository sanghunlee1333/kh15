package api.util.collection;

import java.util.Scanner;

public class Test10포켓몬스터찾기 {

	public static void main(String[] args) {
		
		//String pokemon = "번호 : 1, 이름 : 이상해씨, 속성 : 풀"; //문자열을 포켓몬이라 가정한것 뿐
		//Pokemon pokemon = new Pokemon(1, "이상해씨", "풀"); //이 방법이 객체지향을 이용한 포켓몬 생성 방법
		//System.out.println(pokemon); //toString을 재정의
		
		Scanner sc = new Scanner(System.in);
		
		PokemonDeck pokemonDeck = new PokemonDeck();
		
		pokemonDeck.input(new Pokemon(1, "이상해씨", "풀"));
		pokemonDeck.input(new Pokemon(25, "피카츄", "전기"));
		pokemonDeck.input(new Pokemon(26, "라이츄", "전기"));
		
		System.out.print("포켓몬 이름을 입력하세요 : ");
		String name = sc.next();
		
		pokemonDeck.findPokemon(name);
		
		sc.close();	
	}

}
