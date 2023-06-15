package java05;



		import java.util.HashMap;
		import java.util.Map;

		import net.dv8tion.jda.api.JDA;                                    //
		import net.dv8tion.jda.api.JDABuilder;
		import net.dv8tion.jda.api.entities.Guild;
		import net.dv8tion.jda.api.entities.Member;
		import net.dv8tion.jda.api.entities.Message;                        // JDA 라이브러리 
		import net.dv8tion.jda.api.entities.Role;
		import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
		import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
		import net.dv8tion.jda.api.hooks.ListenerAdapter;                     //

		public class BetaBot extends ListenerAdapter {

		    private static final Map<String, String> BLOOD_TYPE_REACTIONS = new HashMap<>();   // 혈액형
		    private static final Map<String, String> GENDER_REACTIONS = new HashMap<>();      // 성별
		    private static final Map<String, String> AGE_REACTIONS = new HashMap<>();         // 연령대

		    private Message bloodTypeSelectionMessage;
		    private Message genderSelectionMessage;
		    private Message ageSelectionMessage;

		    static {
		        BLOOD_TYPE_REACTIONS.put("🅰", "1113755981181091871"); // A형 역할 ID
		        BLOOD_TYPE_REACTIONS.put("🅱", "1113756059430047765"); // B형 역할 ID
		        BLOOD_TYPE_REACTIONS.put("🆎", "1113756096696418345"); // AB형 역할 ID
		        BLOOD_TYPE_REACTIONS.put("🅾", "1113756128736714803"); // O형 역할 ID
		        
		        GENDER_REACTIONS.put("👨", "1111943248328523828"); // 남자 역할 ID
		        GENDER_REACTIONS.put("👩", "1113378321779142736"); // 여자 역할 ID

		        AGE_REACTIONS.put("1️⃣", "1113849566324867072"); // 10대 역할 ID
		        AGE_REACTIONS.put("2️⃣", "1113849822135472279"); // 20대 역할 ID
		    }

		    public static void main(String[] args) {
		        try {
		/*디스코드봇 ID*/   JDA jda = JDABuilder.createDefault("MTExMzM3ODk4Nzk4OTgwMzA1OA.GTtGXv.wJvu1Xowyk8skE1EMzlw53iK4XsJnjzhul85JQ")
		                    .addEventListeners(new BetaBot())
		                    .build();
		            jda.awaitReady();
		            System.out.println("상태: 온라인");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    @Override
		    public void onMessageReceived(MessageReceivedEvent event) {
		        String messageContent = event.getMessage().getContentRaw();
		        if (messageContent.startsWith("//")) {
		            String command = messageContent.substring(2); // 명령어 '//' 제거
		            if (command.equalsIgnoreCase("혈액형선택")) {
		                bloodTypeSelectionMessage = event.getChannel().sendMessage("귀하의 혈액형을 선택해 주세요\t@everyone\n\n➖➖➖➖➖➖➖➖➖➖➖➖➖➖\n  A형\t\tB형\t AB형\tO형").complete();
		                bloodTypeSelectionMessage.addReaction("🅰").queue();
		                bloodTypeSelectionMessage.addReaction("🅱").queue();
		                bloodTypeSelectionMessage.addReaction("🆎").queue();
		                bloodTypeSelectionMessage.addReaction("🅾").queue();
		            } else if (command.equalsIgnoreCase("성별선택")) {
		                genderSelectionMessage = event.getChannel().sendMessage("귀하의 성별을 선택해 주세요\t@everyone\n\n➖➖➖➖➖➖➖➖➖➖➖➖➖➖\n  남자\t\t여자").complete();
		                genderSelectionMessage.addReaction("👨").queue();
		                genderSelectionMessage.addReaction("👩").queue();
		            } else if (command.equalsIgnoreCase("연령대선택")) {
		                ageSelectionMessage = event.getChannel().sendMessage("귀하의 연령대를 선택해 주세요\t@everyone\n\n➖➖➖➖➖➖➖➖➖➖➖➖➖➖\n  10대\t 20대").complete();
		                ageSelectionMessage.addReaction("1️⃣").queue();
		                ageSelectionMessage.addReaction("2️⃣").queue();
		            }
		        }
		    }

		    @Override
		    public void onMessageReactionAdd(MessageReactionAddEvent event) {
		        if (!event.getUser().isBot()) {
		            if (bloodTypeSelectionMessage != null && bloodTypeSelectionMessage.getId().equals(event.getMessageId())) {
		                String emoji = event.getReactionEmote().getAsReactionCode();
		                String roleId = BLOOD_TYPE_REACTIONS.get(emoji);
		                if (roleId != null) {
		                    Member member = event.getMember();
		                    Guild guild = event.getGuild();
		                    Role role = guild.getRoleById(roleId);

		                    if (role != null) {
		                        // 기존 역할 제거
		                        for (Role existingRole : member.getRoles()) {
		                            if (BLOOD_TYPE_REACTIONS.containsValue(existingRole.getId())) {
		                                guild.removeRoleFromMember(member, existingRole).queue();
		                                break;
		                            }
		                        }
		                        // 새로운 역할 부여
		                        guild.addRoleToMember(member, role).queue();
		                    }
		                }
		            } else if (genderSelectionMessage != null && genderSelectionMessage.getId().equals(event.getMessageId())) {
		                String emoji = event.getReactionEmote().getName();
		                String roleId = GENDER_REACTIONS.get(emoji);
		                if (roleId != null) {               // 역할 선택 잘못눌렀을시 새로운 역할로 이동시키는 구문
		                    Member member = event.getMember();
		                    Guild guild = event.getGuild();
		                    Role role = guild.getRoleById(roleId);

		                    if (role != null) {
		                        // 기존 역할 제거
		                        for (Role existingRole : member.getRoles()) {
		                            if (GENDER_REACTIONS.containsValue(existingRole.getId())) {
		                                guild.removeRoleFromMember(member, existingRole).queue();
		                                break;
		                            }
		                        }
		                        // 새로운 역할 부여
		                        guild.addRoleToMember(member, role).queue();
		                    }
		                }
		            } else if (ageSelectionMessage != null && ageSelectionMessage.getId().equals(event.getMessageId())) {
		                String emoji = event.getReactionEmote().getName();
		                String roleId = AGE_REACTIONS.get(emoji);
		                if (roleId != null) {
		                    Member member = event.getMember();
		                    Guild guild = event.getGuild();
		                    Role role = guild.getRoleById(roleId);

		                    if (role != null) {
		                        // 기존 역할 제거
		                        for (Role existingRole : member.getRoles()) {
		                            if (AGE_REACTIONS.containsValue(existingRole.getId())) {
		                                guild.removeRoleFromMember(member, existingRole).queue();
		                                break;
		                            }
		                        }
		                        // 새로운 역할 부여
		                        guild.addRoleToMember(member, role).queue();
		                    }
		                }
		            }
		        }
		    }
		}
	}

}
