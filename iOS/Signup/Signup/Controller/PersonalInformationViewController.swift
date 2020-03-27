//
//  PersonalInformationViewController.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/27.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class PersonalInformationViewController: UIViewController {
    @IBOutlet weak var birthTextField: SignUpTextField!
    let birthDelegate = BirthdayTextFieldDelegate()
    
    @IBAction func previousButtonPushed(_ sender: UIButton) {
        dismiss(animated: true)
    }
    @IBAction func nextButtonPushed(_ sender: UIButton) {
        let termsViewController = self.storyboard!.instantiateViewController(identifier: "TermsViewController")
        present(termsViewController, animated: true)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        birthTextField.delegate = birthDelegate
    }
}
