function displayImage(input) {
    const file = input.files[0];

    if (file) {
        const reader = new FileReader();

        reader.onload = function (e) {
            const imgElement = document.getElementById('avartar_user-image');
            imgElement.src = e.target.result;
        };

        reader.readAsDataURL(file);
    }
}