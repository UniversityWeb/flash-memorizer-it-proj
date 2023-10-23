<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Review Decks</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/css/review-deck.css">
</head>
<body>
<header>
    <h1>FlashCard</h1>
</header>
<section>
    <div class="tools_content">
        <div class="tool_item dropdown">
            <ion-icon name="receipt-outline"></ion-icon>
            <h3>Test</h3>
            <ion-icon name="chevron-down-outline"></ion-icon>
            <div class="dropdown_menu">
                <a class="dropdown-item" href="#">Multi Choice</a>
                <a class="dropdown-item" href="#">Fill Blank</a>
                <a class="dropdown-item" href="#">Match</a>
            </div>
        </div>
        <div class="tool_item">
            <ion-icon name="share-social-outline"></ion-icon>
            <h3>Share</h3>
            <ion-icon name="open-outline"></ion-icon>
        </div>
        <div class="tool_item">
            <ion-icon name="pencil-outline"></ion-icon>
            <h3>Edit</h3>
        </div>
    </div>
    <div class="flip_cards_content">
        <div class="wrapper">
            <div class="flip_cards-container">
                <div class="flip_cards">
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <c:forEach var="card" items="${deck.cards}">
                        <div class="flip_card_frame" onclick="toggleFlip(this)">
                            <div class="flip_card_inner">
                                <div class="flip_card_front flip_card_content">
                                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                    <c:if test="${card.term != null}">
                                        <button class="button_read" onclick="readContentAndStopPropagation(event)">
                                            <ion-icon name="volume-medium-outline"></ion-icon>
                                        </button>
                                        <p class="flip_card_text">${card.term}</p>
                                    </c:if>
                                    <c:if test="${card.term == null}">
                                        <img src="../static/images/empty.gif" class="empty">
                                    </c:if>
                                </div>
                                <div class="flip_card_back flip_card_content">
                                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                    <c:if test="${card.desc != null}">
                                        <button class="button_read" onclick="readContentAndStopPropagation(event)">
                                            <ion-icon name="volume-medium-outline"></ion-icon>
                                        </button>
                                        <p class="flip_card_text">${card.desc}</p>
                                    </c:if>
                                    <c:if test="${card.desc == null}">
                                        <img src="../static/images/empty.gif" class="empty">
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="flip_card_controls">
            <ion-icon name="arrow-back-outline" class="flip_cards_button" id="prev"></ion-icon>

            <!-- Sửa lại truyền từ java này để tạm thời-->
            <div class="flip_card_count">
                <p class="flip_card_index">1</p>
                <p>&sol;</p>
                <p class="flip_card_total">1</p>
            </div>

            <ion-icon name="arrow-forward-outline" class="flip_cards_button" id="next"></ion-icon>
        </div>
        <div class="process_bar_container">
            <div class="process_bar"></div>
        </div>
    </div>
</section>

<script src="../static/js/review-deck.js"></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>