
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/membership-cards")
public class MembershipCardController {

    @Autowired
    private MembershipCardService membershipCardService;

    @GetMapping
    public List<MembershipCard> getAllMembershipCards() {
        log.info("Fetching all membership cards");
        return membershipCardService.getAllMembershipCards();
    }

    @PostMapping("/upgrade")
    public void upgradeMembershipCard(@RequestBody MembershipCard membershipCard) {
        log.info("Upgrading membership card: {}", membershipCard);
        membershipCardService.upgradeMembershipCard(membershipCard);
    }

    @DeleteMapping("/{id}")
    public void deleteMembershipCard(@PathVariable int id) {
        log.info("Deleting membership card with id: {}", id);
        membershipCardService.deleteMembershipCard(id);
    }
}
