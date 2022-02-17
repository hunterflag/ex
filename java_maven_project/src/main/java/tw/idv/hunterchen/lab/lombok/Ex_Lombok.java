package tw.idv.hunterchen.lab.lombok;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data	//=@Getter@Setter@ToString@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Ex_Lombok {
	private int id;
	private String tag;
	private Date created = new Date(System.currentTimeMillis());
	
	public void sayHi() {
		log.info("Haaaa");
	}
}
