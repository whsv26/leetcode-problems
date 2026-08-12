void main() {
    assert (1 == finalValueAfterOperations(new String[]{"--X", "X++", "++X"}));
}

int finalValueAfterOperations(String[] operations) {
    var res = 0;
    for (var operation : operations) {
        switch (operation) {
            case "--X", "X--" -> res--;
            case "++X", "X++" -> res++;
        }
    }
    return res;
}
