package api.util.collection;

import java.util.ArrayList;
import java.util.List;

//포켓몬 덱
public class PokemonDeck {
	// 포켓몬 여러 개
	private List<Pokemon> pokemonDeck; // List<List<String>>

	// 생성자 : 포켓몬들을 전달받아서 설정할 수 있게 해야 함. 포켓몬 자체를 생성 X
	public PokemonDeck() {
		this.pokemonDeck = new ArrayList<>();
	}

	public PokemonDeck(List<Pokemon> pokemon) {
		this.pokemonDeck = pokemon;
	}

	// 메소드 : 정보 입력
	public void input(Pokemon pokemon) {
		pokemonDeck.add(pokemon);
	}

	// 메소드 : 정보 찾기
	public void findPokemon(String name) {
		for (int i = 0; i < pokemonDeck.size(); i++) {
			Pokemon pokemon = pokemonDeck.get(i);
			if (pokemon.getName().equals(name)) {
				System.out.println(pokemon.toString());
				return;
			}
		}
		System.out.println("몬스터가 존재하지 않습니다");
	}

}
