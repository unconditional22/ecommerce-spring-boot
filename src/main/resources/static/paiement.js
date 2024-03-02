// Function to handle dynamic fields based on payment method
function handlePaymentMethod() {
    var paymentMethod = $('#paymentMethod').val();

    // Show/hide fields based on the selected payment method
    if (paymentMethod === 'creditCard') {
        $('#cardNumberField').show();
        $('#expiryDateField').show();
        $('#cvvField').show();
    } else {
        $('#cardNumberField').hide();
        $('#expiryDateField').hide();
        $('#cvvField').hide();
        $('#statutPaiementField').hide();
    }
}

// Function to submit payment
// Function to handle dynamic fields based on payment method
function handlePaymentMethod() {
    var paymentMethod = $('#paymentMethod').val();

    // Show/hide fields based on the selected payment method
    if (paymentMethod === 'creditCard') {
        $('#cardNumberField').show();
        $('#expiryDateField').show();
        $('#cvvField').show();
    } else {
        $('#cardNumberField').hide();
        $('#expiryDateField').hide();
        $('#cvvField').hide();
        $('#statutPaiementField').hide();
    }
}

// Function to submit payment
function submitPayment() {
    // You can add validation logic here before submitting the payment

    // Assuming you want to make an AJAX request to process the payment
    $.ajax({
        type: 'POST',
        url: '/process-paiement', // Replace with your actual endpoint
        contentType: 'application/json',
        data: JSON.stringify({
            amount: $('#amount').val(),
            paymentMethod: $('#paymentMethod').val(),
            cardNumber: $('#cardNumber').val(),
            expiryDate: $('#expiryDate').val(),
            cvv: $('#cvv').val(),
            statutPaiement: $('#statutPaiement').val(), // Add this line to include statutPaiement
            // Add other fields as needed
        }),
        success: function(response) {
            // Handle success, e.g., show a confirmation message
            console.log(response);
            alert('Paiement fait avec success!');
        },
        error: function(error) {
            // Handle error
            console.error('Error processing payment:', error);
            alert('Paiement echouer. Veillez re-essayer.');
        }
    });
}

// Attach the handlePaymentMethod function to the change event of the paymentMethod select element
$('#paymentMethod').change(handlePaymentMethod);

// Attach the submitPayment function to the click event of the "submit paiement" button
$('#submitPaiementBtn').click(submitPayment);

// Initial call to handlePaymentMethod to set initial field visibility
handlePaymentMethod();


