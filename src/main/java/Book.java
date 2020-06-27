import lombok.*;


import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Book {
    private String name;
    private List<String> author;
    private int price;
}
